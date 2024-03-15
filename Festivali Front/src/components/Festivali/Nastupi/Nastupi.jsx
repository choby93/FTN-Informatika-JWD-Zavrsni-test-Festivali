import React, { useCallback, useEffect, useState } from "react";
import { Button, Col, Form, Row, Table } from "react-bootstrap";
import Axios from "../../../apis/Axios";
import NastupRow from "./NastupRow";

const Nastupi = () => {
  const init = {
    izvodjacId: "",
    festivalId: "",
  };

  const [nastup, setNastup] = useState([]);
  const [izvodjaci, setIzvodjaci] = useState([]);
  const [festivali, setFestivali] = useState([]);
  const [novNastup, setNovNastup] = useState(init);
  const [pageNo, setPageNo] = useState(0);
  const [totalPage, setTotalPage] = useState(0);
  const [pretraga, setPretraga] = useState({
    izvodjacId: "",
    festivalId: "",
  });

  //preuzimanje nastupa
  const getNastupi = useCallback((nextPage) => {
    const config = {
      params: {
        pageNo: nextPage,
        festivalId: pretraga.festivalId,
        izvodjacId: pretraga.izvodjacId,
      },
    };

    Axios.get("/nastupi", config)
      .then((ress) => {
        setNastup(ress.data);
        console.log(ress);
        setPageNo(nextPage);
        setTotalPage(ress.headers["total-pages"]);
      })
      .catch((err) => {
        console.log(err);
        alert("Došlo je do greške u preuzimanju!");
      });
  }, []);

  //preuzimanje izvođača
  const getIzvodjaci = useCallback(() => {
    Axios.get("/izvodjaci")
      .then((ress) => setIzvodjaci(ress.data))
      .catch((err) => {
        console.log(err);
        alert("Došlo je do greške u preuzimanju izvođača");
      });
  }, []);

  //preuzimanje festivala
  const getFestivali = useCallback(() => {
    Axios.get("/festivali")
      .then((ress) => setFestivali(ress.data))
      .catch((err) => {
        console.log(err);
        alert("Došlo je do greške u preuzimanju festivala");
      });
  }, []);

  useEffect(() => {
    getIzvodjaci();
    getFestivali();
    getNastupi(0);
  }, []);

  //dodavanja nastupa
  const addNastup = () => {
    let params = {
      izvodjacId: novNastup.izvodjacId,
      festivalId: novNastup.festivalId,
    };

    Axios.post("/nastupi", params)
      .then((result) => {
        alert("Uspešno dodavanje!");
        console.log(result);
        window.location.reload();
      })
      .catch((err) => {
        console.log(err);
        alert("Došlo je do greške prilikom slanja!");
      });
  };

  //pretraga
  const pretragaNastupa = (e) => {
    let name = e.target.name;
    let value = e.target.value;

    let novaPretraga = pretraga;
    novaPretraga[name] = value;
    setPretraga(novaPretraga);
    getNastupi(0);
  };

  //promena vrednosti unosa
  const inputValueChange = (e) => {
    let name = e.target.name;
    let value = e.target.value;

    let nov = novNastup;
    nov[name] = value;
    setNovNastup(nov);
  };

  //ispis nastupa
  const renderNastupi = () => {
    return nastup.map((nastup, index) => {
      return <NastupRow key={nastup.id} nastup={nastup} />;
    });
  };

  // select izvođača
  const izvodjaciSelect = () => {
    return izvodjaci.map((izvodjac) => {
      return (
        <option key={izvodjac.id} value={izvodjac.id}>
          {izvodjac.ime}
        </option>
      );
    });
  };

  // select festival
  const festivaliSelect = () => {
    return festivali.map((festival) => {
      return (
        <option key={festival.id} value={festival.id}>
          {festival.naziv}
        </option>
      );
    });
  };

  return (
    <Row>
      <Col>
        {window.localStorage["jwt"] ? (
          <Row>
            <Form style={{ display: "flex", justifyContent: "space-between" }}>
              <Col>
                <Form.Label>Izvodjac</Form.Label>
                <Form.Select
                  name="izvodjacId"
                  onChange={(e) => inputValueChange(e)}
                >
                  <option value={""}></option>
                  {izvodjaciSelect()}
                </Form.Select>
              </Col>
              <Col>
                <Form.Label>Festival</Form.Label>
                <Form.Select
                  name="festivalId"
                  onChange={(e) => inputValueChange(e)}
                >
                  <option value={""}></option>
                  {festivaliSelect()}{" "}
                </Form.Select>
              </Col>
            </Form>
            <Col>
              <Button className="mt-2" onClick={addNastup}>
                Kreiraj
              </Button>
            </Col>
          </Row>
        ) : null}
        <Col>
          <h1>Pretraga</h1>
          <Form style={{ display: "flex", justifyContent: "space-between" }}>
            <Col>
              <Form.Label>Izvodjac</Form.Label>
              <Form.Select
                name="izvodjacId"
                onChange={(e) => pretragaNastupa(e)}
              >
                <option value={""}></option>
                {izvodjaciSelect()}
              </Form.Select>
            </Col>
            <Col>
              <Form.Label>Festival</Form.Label>
              <Form.Select
                name="festivalId"
                onChange={(e) => pretragaNastupa(e)}
              >
                <option value={""}></option>
                {festivaliSelect()}
              </Form.Select>
            </Col>
          </Form>
        </Col>

        <Row>
          <h1>Nastupi</h1>
        </Row>
        <Row>
          <Table>
            <thead>
              <tr>
                <th>Izvođač</th>
                <th>Festival</th>
                <td></td>
              </tr>
            </thead>
            <tbody>{renderNastupi()}</tbody>
          </Table>
        </Row>
        <Row>
          <Col>
            <Button
              disabled={pageNo == 0}
              onClick={() => getNastupi(pageNo - 1)}
            >
              Prethodna
            </Button>
            <Button
              disabled={pageNo + 1 == totalPage || nastup.length == 0}
              onClick={() => getNastupi(pageNo + 1)}
            >
              Sledeca
            </Button>
          </Col>
        </Row>
      </Col>
    </Row>
  );
};

export default Nastupi;
