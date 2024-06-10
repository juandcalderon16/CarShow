
import React, { Component } from "react";
import { Link } from "react-router-dom";

class Header extends Component {  
  
  render() {
    return (
      
      <header id="header">
        <div className="center">
            <Link to="/IniciarSesion" className="btn -inicioSesion" >
              Iniciar Sesion
            </Link>

          <div id="logo">
            <span id="brand">
              <strong id="CarShow">CarShow</strong>
            </span>
          </div>
        </div>
      </header>
    );
  }
}


export default Header;

/*const Header = () => {
  const { estaLogeado, logout } = useContext(UserContext);

  return (
    <header id="header">
      <div className="center">
        {estaLogeado ? (
          <Link to="/" className="btn -inicioSesion" onClick={logout}>
          cerrar sesion
        </Link>
        ) : (
          <Link to="/IniciarSesion" className="btn -inicioSesion">
            Iniciar Sesión
          </Link>
        )}

        <div id="logo">
          <span id="brand">
            <strong id="CarShow">CarShow</strong>
          </span>
        </div>
      </div>
    </header>
  );
};*/

