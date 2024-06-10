import React, { Component } from "react";
import { Link } from "react-router-dom";

class HeaderSesionON extends Component {

  render() {
    return (

      <header id="header">
        <div className="center">
          <div id="logoSesionOn">
            <span id="brand">
              <strong id="CarShow">CarShow</strong>
            </span>
          </div>
          <nav id="menu">
            <ul>
              <li>
                <Link to="/SesionIniciada">Inicio</Link>
              </li>
              <li>
              <Link to="/SesionIniciada">Nuestros Vehiculos</Link>
              </li>
              <li>
                <a href="https://www.portafolio.co/economia/finanzas/cinco-pasos-compras-tienda-virtual-90232">
                  Como Comprar!!?</a>
              </li>
            </ul>
            <Link to="/" className="btn -cerrarSesion" onClick={() => { localStorage.clear() }} >
              Cerrar Sesion
            </Link>
          </nav>

        </div>
      </header>
    );
  }
}


export default HeaderSesionON;