import React, { Component } from "react";
import axios from "axios";
import Header from "./Header";



class CrearPerfil extends Component {

    nombreRef = React.createRef();
    apellidoRef = React.createRef();
    edadRef = React.createRef();
    usuarioRef = React.createRef();
    paswordRef = React.createRef();

    state = {
        usuario: {}
    };

    recibirFormulario = (e) => {
        e.preventDefault();

        var usuario = {
            nombre: this.nombreRef.current.value,
            apellido: this.apellidoRef.current.value,
            edad: this.edadRef.current.value,
            userName: this.usuarioRef.current.value,
            password: this.paswordRef.current.value,    
        }

        alert("formulario enviado");
        alert(this.nombreRef.current.value)
        console.log(usuario);

        axios.post("http://localhost:8080/api/usuarios", usuario)
            .then(response => {
                console.log(response.data); // Maneja la respuesta del backend
                alert("Usuario creado exitosamente");
            })
            .catch(error => {
                console.error("Error al crear usuario:", error);
                if (error.response && error.response.status === 500){
                alert("Hubo un error al crear el usuario. Ese nombre de ususario ya esta en uso.");
            }   else {
                alert("Hubo un error al crear el usuario.")
            }
            });
    }


    render() {
        return (
            <div>
                < Header/>
            <div id="form-crear" className="form">
                <h1>Crea tu perfil en CarShow</h1>
                <form onSubmit={this.recibirFormulario}>
                    <div className="inputbox">
                        <input type="text" required="required" ref={this.nombreRef} />
                        <span>Nombre</span>
                    </div>
                    <div className="inputbox">
                        <input type="text" required="required" ref={this.apellidoRef} />
                        <span>Apellido</span>
                    </div>
                    <div className="inputbox">
                        <input type="number" required="required" ref={this.edadRef} />
                        <span>Edad</span>
                    </div>
                    <div className="inputbox">
                        <input type="text" required="required" ref={this.usuarioRef} />
                        <span>Usuario</span>
                    </div>
                    <div className="inputbox">
                        <input type="text" required="required" ref={this.paswordRef} />
                        <span>Password</span>
                    </div>
                    <div className="inputbox">
                        <input type="submit" value="Crear Perfil" />
                    </div>
                </form>
            </div>
            </div>
        );
    }
}

export default CrearPerfil;