import React, { useCallback, useEffect, useState } from "react";
import { Button, Col, Form, Row, Table } from "react-bootstrap";
import Axios from "../../../apis/Axios";
import IzvodjacRow from "./IzvodjacRow";

const Izvodjaci = () => {
  const stanjeZaDodavanje = {
    ime: "",
    zanr: "",
    drzava: "",
    brojClanova: "",
  };

  const [izvodjaci, setIzvodjaci] = useState([]);
  const [novIzvodjac, setNovIzvodjac] = useState(stanjeZaDodavanje);
  const [validno, setValidno] = useState(false);

  //dobavljanje svih izvodjaca
  const getIzvodjaci = useCallback(() => {
    Axios.get("/izvodjaci")
      .then((ress) => {
        console.log(ress);
        setIzvodjaci(ress.data);
      })
      .catch((error) => {
        console.log(error);
        alert("Došlo je do greške u preuyimanju!");
      });
  }, []);

  useEffect(() => {
    getIzvodjaci();
  }, []);

  //dodavanje izvodjaca
  const addIzvodjac = () => {
    const param = {
      ime: novIzvodjac.ime,
      zanr: novIzvodjac.zanr,
      drzava: novIzvodjac.drzava,
      brojClanova: novIzvodjac.brojClanova,
    };

    Axios.post("/izvodjaci", param)
      .then((ress) => {
        console.log(ress);
        alert("Uspešno dodavanje!!!");
        window.location.reload();
      })
      .catch((err) => {
        console.log(err);
        alert("Došlo je do greške!!!");
      });
  };

  //Validacija
  const validacija = () => {
    if (
      novIzvodjac.ime == "" ||
      novIzvodjac.zanr == "" ||
      novIzvodjac.drzava == "" ||
      novIzvodjac.brojClanova == ""
    ) {
      setValidno(false);
    } else {
      setValidno(true);
    }
  };

  //onChange
  const inputValueChange = (e) => {
    let name = e.target.name;
    let value = e.target.value;

    let nov = novIzvodjac;
    nov[name] = value;
    setNovIzvodjac(nov);
    validacija();
  };

  const renderIzvodjaci = () => {
    return izvodjaci.map((izvodjac, index) => {
      return <IzvodjacRow key={izvodjac.id} izvodjac={izvodjac}></IzvodjacRow>;
    });
  };

  const renderDodavanje = () => {
    return (
      <>
        <Row>
          <Col xs="12" sm="10" md="8">
            <Form>
              <Form.Label htmlFor="ime">Naziv</Form.Label>
              <Form.Control
                name="ime"
                id="ime"
                type="text"
                onChange={(e) => inputValueChange(e)}
              />
              <Form.Label htmlFor="drzava">Država porekla</Form.Label>
              <Form.Control
                name="drzava"
                id="drzava"
                type="text"
                onChange={(e) => inputValueChange(e)}
              />
              <Form.Label htmlFor="zanr">Žanr</Form.Label>
              <Form.Control
                name="zanr"
                id="zanr"
                type="text"
                onChange={(e) => inputValueChange(e)}
              />
              <Form.Label htmlFor="brojClanova">Broj članova</Form.Label>
              <Form.Control
                name="brojClanova"
                id="brojClanova"
                type="number"
                onChange={(e) => inputValueChange(e)}
              />
              <br />
              <Button onClick={addIzvodjac} disabled={!validno}>
                Kreiraj
              </Button>
            </Form>
          </Col>
        </Row>
      </>
    );
  };

  //krajnji ispis
  return (
    <Col>
      <Row>
        <h1>Izovođači</h1>
      </Row>
      <Row>
        {window.localStorage.getItem("role") == "ROLE_ADMIN"
          ? renderDodavanje()
          : null}
      </Row>
      <Row>
        <Col>
          <Table>
            <thead>
              <tr>
                <th>Naziv</th>
                <th>Zanr</th>
                <th>Drzava porekla</th>
                <th>Broj clanova</th>
              </tr>
            </thead>
            <tbody>{renderIzvodjaci()}</tbody>
          </Table>
        </Col>
      </Row>
    </Col>
  );
};

export default Izvodjaci;
