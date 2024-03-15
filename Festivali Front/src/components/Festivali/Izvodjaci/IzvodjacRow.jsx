import React from 'react'

const IzvodjacRow = (props) => {

  const brojNastupa = ()=>{
    return alert (props.izvodjac.brojNastupa)
}

  return (
   
    <tr onClick={brojNastupa} key={props.izvodjac.izvodjac}>
        <td>{props.izvodjac.ime}</td>
        <td>{props.izvodjac.zanr}</td>
        <td>{props.izvodjac.drzava}</td>
        <td>{props.izvodjac.brojClanova}</td>
    </tr>


  )
}

export default IzvodjacRow