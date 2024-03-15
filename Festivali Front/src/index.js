import React from "react";
import { createRoot } from 'react-dom/client';
import { Route, Link, HashRouter as Router, Routes } from "react-router-dom";
import { Navbar, Nav, Container, Button } from "react-bootstrap";
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import 'bootstrap/dist/css/bootstrap.min.css';
import { logout } from "./services/auth";
import { Navigate } from "react-router-dom/dist";
import Login from "./components/authorization/Login";
import Izvodjaci from "./components/Festivali/Izvodjaci/Izvodjaci";
import Nastupi from "./components/Festivali/Nastupi/Nastupi";




const App = () => {
  if (window.localStorage["jwt"]) {
    return (
      <>
        <Router>
          <Navbar expand bg="dark" variant="dark">
           
            <Nav>
            <h3 style={{ color: 'white' , paddingRight: "20px", paddingLeft: "20px"}}>JWD <br/></h3>
              <Nav.Link as={Link} to='/izvodjaci'>Izvođači</Nav.Link>
              <Nav.Link as={Link} to='/nastupi'>Nastupi</Nav.Link>
              <Button onClick={logout}>Logout</Button>
            </Nav>
          </Navbar>
          <Container style={{ paddingTop: "25px" }}>
            <Routes>
              <Route path="/" element={<Home />} />       
              <Route path="*" element={<NotFound />} />
              <Route path="/izvodjaci" element={<Izvodjaci/>}/>
              <Route path="/nastupi" element={<Nastupi/>}/>
            </Routes>
          </Container>
        </Router>
      </>
    );
  } else {
    return (
      <>
        <Router>
          <Navbar expand bg="dark" variant="dark">
    
            <Nav>    
              <Nav.Link as={Link} to="/nastupi">Nastupi</Nav.Link>
              <Button as={Link} to="/login">Login</Button>

            </Nav>
          </Navbar>
          <Container style={{ paddingTop: "25px" }}>
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/login" element={<Login />} />
              <Route path="*" element={<Navigate replace to="/login" />} />
              <Route path="/nastupi" element={<Nastupi/>}/>
            </Routes>
          </Container>
        </Router>
      </>
    );
  }
};

const rootElement = document.getElementById('root');
const root = createRoot(rootElement);

root.render(
  <App />,
);
