
import React, { useState, useEffect } from 'react';
import HeaderSesionON from './Header/HeaderSesionOn';
import axios from 'axios';
import { useNavigate } from "react-router-dom";

const CarColorPicker = () => {

  const navigate = useNavigate();

  const [persoId, setPersoId] = useState(0);
  const [descripcionCarro, setDescripcionCarro] = useState("");
  const [precio, setPrecio] = useState(0);

  useEffect(() => {
    // Es una recarga de página, haz la llamada al backend
    axios.get("http://localhost:8080/api/facturacion/factura")
      .then(response => {
        console.log(response.data); // Maneja la respuesta del backend
        setPersoId(response.data);
        console.log(persoId);
      })
      .catch(error => {
        console.error('Error al obtener el usuario:', error);
      });

    axios.get("http://localhost:8080/api/facturacion/carro/precio")
      .then(response => {
        console.log(response.data); // Maneja la respuesta del backend
        setPrecio(response.data);
        console.log(precio);
      })
      .catch(error => {
        console.error('Error al obtener el usuario:', error);
      });



    axios.get("http://localhost:8080/api/facturacion/carro")
      .then(response => {
        console.log(response.data); // Maneja la respuesta del backend
        setDescripcionCarro(response.data);
        console.log(descripcionCarro);
      })
      .catch(error => {
        console.error('Error al obtener el usuario:', error);
      });

  }, []);


  const facturar = () => {


    const datosFacturacion = ({
      personalizacionId: persoId,
      estadoId: 2
    });

    axios.post("http://localhost:8080/api/facturacion/crearFac", datosFacturacion)
      .then(response => {
        console.log(response.data); // Maneja la respuesta del backend
        alert("Facturado exitosamente");
      })
      .catch(error => {
        console.error("Error al facturar:", error);
        if (error.response) {
          if (error.response.status === 404) {
            alert("Usuario, carro o personalización no encontrados.");
          } else if (error.response.status === 500) {
            alert("Hubo un error interno en el servidor.");
          } else {
            alert("Hubo un error al facturar.");
          }
        } else {
          alert("Hubo un error al conectar con el servidor.");
        }
      });
  };

  const cancelar = () => {

    axios.delete(`http://localhost:8080/api/facturacion/eliminar/${persoId}`)
      .then(response => {
        console.log(response.data); 
        alert("Personalización de carro eliminada");
        navigate('/SesionIniciada');
      })
      .catch(error => {
        console.error('Error al obtener el usuario:', error);
        alert("error")
      });
  };



  return (
    <div>
      <HeaderSesionON />
      <div className="carro-color-picker-container">
        <div className="color-picker">
          <h1>Factura</h1>
        </div>

        <div className="color-picker">
          <h2>Datos de facturacion: </h2>
          <div className="color-options">
            <h2>
              {descripcionCarro} </h2>

          </div>
          <h2>Elige el color de los rines</h2>
          <div className="color-options">
          </div>
        </div>
        <div className="carro-display">
        </div>

        <div>
          <h3>Precio total: ${precio}</h3>
          <button className='facturar' id='pagar' onClick={() => facturar()}>
            Proceder al pago
          </button>
          <button className='facturar' id='cancelar' onClick={() => cancelar()}>
            cancelar compra
          </button>
        </div>
      </div>
    </div>
  );
}

export default CarColorPicker;