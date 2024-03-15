import React from "react";
import { Button } from "react-bootstrap";
import Axios from "../../../apis/Axios";

const NastupRow = (props) => {
  const nastupId = props.nastup.id;

  //brisanje nastupa
  const deleteNastup = () => {
    Axios.delete("/nastupi/" + nastupId)
      .then((result) => {
        console.log(result);
        window.location.reload();
      })
      .catch((err) => {
        console.log(err);
        alert("Došlo je do greške u brisanju!");
      });
  };
  return (
    <tr key={props.nastup.id}>
      <td>{props.nastup.izvodjacIme}</td>
      <td>{props.nastup.festivalNaziv}</td>
      <td>
        {window.localStorage["role"] == "ROLE_ADMIN" ? (
          <Button variant="danger" onClick={deleteNastup}>
            Izbriši
          </Button>
        ) : null}
      </td>
    </tr>
  );
};

export default NastupRow;
