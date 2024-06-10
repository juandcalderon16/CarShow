import React, { useState, useEffect } from 'react';
import CarController from './CarController';
import { useUser } from './UserContext';
import { useNavigate } from "react-router-dom";


import s11 from '../assets/images/Mazda/1.jpg';
import s21 from '../assets/images/Mazda/2.jpg';
import s31 from '../assets/images/Mazda/3.jpg';
import HeaderSesionON from './Header/HeaderSesionOn';
import axios from 'axios';
import userEvent from '@testing-library/user-event';
  
const Miata = () => {



  const [precioBase, setBasePrice] = useState(0);
  const [nombreCarro, setNombreCarro] = useState("");
  const [colorPrices, setColorPrices] = useState();
  const { user } = useUser();
  const [cliente, setCliente] = useState("");
  const navigate = useNavigate();

  const carId = "4";

  const usuario = {
    nombre: '',
    apellido: '',
    edad: 1,
    userName: "juandini",
    password: ''
  }

  const carro = {
    id_carro: carId,
    marca: '',
    modelo: '',
    precio: 1,
    referencia: "juandini",
    proveedor: 3
  }

  const personalizacion = {
    color: '',
    descripcion: '',
    precio: 5000000,
    rines: 1
  }

  

  useEffect(() => {
    // Obtener precio base desde el backend
    CarController.getPrecioCarro(carId).then(response => {
      setBasePrice(response.data);
      console.log(response.data);
    }).catch(error => {
      console.log(error);
    })
      },[])

    useEffect(() => {
        // Obtener precio base desde el backend
        CarController.getCarroName(carId).then(response => {
          setNombreCarro(response.data);
          console.log(response.data);
        }).catch(error => {
          console.log(error);
        })
          },[])

          useEffect(() => {
              // Es una recarga de página, haz la llamada al backend
              axios.get("http://localhost:8080/api/usuarios/sesionIniciada")
                .then(response => {
                  setCliente(response.data);
                  console.log(cliente);
                })
                .catch(error => {
                  console.error('Error al obtener el usuario:', error);
                });
            
          }, []);
      

    // Obtener precios de colores desde el backend

  const [selectedExterior, setSelectedExterior] = useState('s1');
  const [selectedInterior, setSelectedInterior] = useState('1');


  const images = {
    s1: {
      1: s11
    },
    s2: {
      1: s21
    },
    s3: {
      1: s31
    }
  };

  const exteriorColors = [
    { name: 's1', color: '#961E1F', precio: 1000000 },
    { name: 's2', color: '#000000', precio: 4000000 },
    { name: 's3', color: '#C0C0C0', precio: 2000000 }
  ];

  const calcularPrecioTotal = () => {
    let total = precioBase;
    exteriorColors.forEach(color => {
      if (color.name === selectedExterior) total += color.precio;
    });
    return total;
  };

  const calcularPrecioColores = () => {
    let total = 0;
    exteriorColors.forEach(color => {
      if (color.name === selectedExterior) total += color.precio;
    });
    return total;
  };

  


const facturar = () => {

  const total = calcularPrecioColores();
    
  const datosFacturacion = ({
    usuario: cliente,
    carroId: 4,
    precioPerso: total // Valor inicial
  });

    axios.post("http://localhost:8080/api/facturacion", datosFacturacion)
        .then(response => {
            console.log(response.data); // Maneja la respuesta del backend
            alert("Facturado exitosamente a " + cliente);
            console.log(user);
            navigate('/Facturacion');
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

  return (
    <div>
      <HeaderSesionON />
    <div className="carro-color-picker-container">
      <h2>{nombreCarro}</h2>
      <div className="carro-display">
        <img
          id="car-image"
          src={images[selectedExterior][selectedInterior]}
          alt={`Mazda CX-5 ${selectedExterior} con interior ${selectedInterior}`}
        />
      </div>
      <div className="color-picker">
        <h2>Elige el color exterior </h2>
        <div className="color-options">
          {exteriorColors.map(color => (
            <div
              key={color.name}
              className="color-option"
              style={{ backgroundColor: color.color }}
              onClick={() => setSelectedExterior(color.name)}
            ></div>
          ))}
        </div>
      </div>
      <div>
        <h3>Precio total: ${calcularPrecioTotal()}</h3>
        <button className='facturar' id='facturar' onClick={() => facturar()}>
          Facturar
        </button>
      </div>
    </div>
    </div>
  );
}

export default Miata;