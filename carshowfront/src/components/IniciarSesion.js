import React, { useRef, useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import Header from './Header';
import { useUser } from './UserContext';


const IniciarSesion = () => {
  const usuarioRef = useRef();
  const passwordRef = useRef();
  const [body, setBody] = useState({ usuario: '', password: '' })
  const navigate = useNavigate()
  const { setUser } = useUser();


  const inputChange = ({ target }) => {
    const { name, value } = target
    setBody({
      ...body,
      [name]: value
    })
  }

  const enviar = () =>{
    console.log(body)
  }

  const recibirFormulario = (e) => {
    e.preventDefault();

    const usuario = {
      nombre: '',
      apellido: '',
      edad: 1,
      userName: usuarioRef.current.value,
      password: passwordRef.current.value
    }



    axios.post("http://localhost:8080/api/usuarios/iniciarSesion", usuario)
      .then(({ data }) => {
        localStorage.setItem('auth', '"yes"')
          alert("Usuario logeado exitosamente");
          //window.location.href = "/";
          // Redirect the user to a different page or perform some other action
          navigate('/SesionIniciada');
          setUser(data);
      })
      .catch(error => {
        console.error("Error al loguear usuario:", error);
        if (error.response && error.response.status === 401) {
          alert("Hubo un error. Usuario o contraseña incorrectos.");
        } else {
          alert("Hubo un error.");
          // Handle other types of errors
        }
      });
  }

  return (
    <div>
      <Header />
      <div className="form">
        <h1>Ingresa a CarShow</h1>
        <form onSubmit={recibirFormulario}>
          <div className="inputbox">
            <input type="text" required="required" ref={usuarioRef} value={body.usuario} onChange={inputChange}
              name='usuario' />
            <span>Usuario</span>
          </div>
          <div className="inputbox">
            <input type="text"
              required="required"
              ref={passwordRef}
              value={body.password}
              onChange={inputChange}
              name='password' />
            <span>Password</span>
          </div>
          <div className="inputbox">
            <input type="submit" value="Iniciar Sesion" onClick={enviar}/>
          </div>
          <p className="link-create-profile">No tienes usuario?<Link to="/CrearPerfil">
            Crear perfil
          </Link></p>
        </form>
      </div>
    </div>
  );
}

export default IniciarSesion;
/*class IniciarSesion extends Component {
  static contextType = UserContext;

  usuarioRef = React.createRef();
  passwordRef = React.createRef();

  state = {
    usuario: {}
  };

  recibirFormulario = (e) => {
    e.preventDefault();

    var usuario = {
      nombre: "this.nombreRef.current.value",
      apellido: "this.apellidoRef.current.value",
      edad: 1,
      userName: this.usuarioRef.current.value,
      password: this.passwordRef.current.value
    }



    alert("formulario enviado");
    alert(this.usuarioRef.current.value)
    console.log(usuario);

    axios.post("http://localhost:8080/api/usuarios/iniciarSesion", usuario)
      .then(response => {
        console.log(response.data); // Maneja la respuesta del backend
        if (response.status === 200) {
          const { login } = this.context;
          login(usuario.userName);
          alert("Usuario logeado exitosamente");
          //window.location.href = "/";
          // Redirect the user to a different page or perform some other action
        }
      })
      .catch(error => {
        console.error("Error al loguear usuario:", error);
        if (error.response && error.response.status === 401) {
          alert("Hubo un error. Usuario o contraseña incorrectos.");
        } else {
          alert("Hubo un error.");
          // Handle other types of errors
        }
      });
  }

  render() {
    return (
      <div>
      <div className="form">
        
        <h1>Ingresa a CarShow</h1>
        <form onSubmit={this.recibirFormulario}>
          <div className="inputbox">
            <input type="text" required="required" ref={this.usuarioRef} />
            <span>Usuario</span>
          </div>
          <div className="inputbox">
            <input type="text" required="required" ref={this.passwordRef} />
            <span>Password</span>
          </div>
          <div className="inputbox">
            <input type="submit" value="Iniciar Sesion" />
          </div>
          <p className="link-create-profile">No tienes usuario?<Link to="/CrearPerfil">
            Crear perfil
          </Link></p>
        </form>
      </div>
      </div>
    );
  }
}*/