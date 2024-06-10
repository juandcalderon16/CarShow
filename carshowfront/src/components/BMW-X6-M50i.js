import React, { useState, useEffect } from 'react';
import CarController from './CarController';
import { useUser } from './UserContext';
import { useNavigate } from "react-router-dom";


import negro1 from '../assets/images/BMW/bmw-negro1.png';
import negro2 from '../assets/images/BMW/bmw-negro2.png';
import negro3 from '../assets/images/BMW/bmw-negro3.png';
import azul1 from '../assets/images/BMW/bmw-azul3.png';
import azul2 from '../assets/images/BMW/bmw-azul2.png';
import azul3 from '../assets/images/BMW/bmw-azul1.png';
import rojo1 from '../assets/images/BMW/bmw-rojo1.png';
import rojo2 from '../assets/images/BMW/bmw-rojo3.png';
import rojo3 from '../assets/images/BMW/bmw-rojo2.png';
import blanco1 from '../assets/images/BMW/bmw-blanco1.png';
import blanco2 from '../assets/images/BMW/bmw-blanco3.png';
import blanco3 from '../assets/images/BMW/bmw-blanco2.png';
import HeaderSesionON from './Header/HeaderSesionOn';
import axios from 'axios';
import userEvent from '@testing-library/user-event';
  
const BMWX6M50i = () => {



  const [precioBase, setBasePrice] = useState(0);
  const [nombreCarro, setNombreCarro] = useState("");
  const [colorPrices, setColorPrices] = useState();
  const { user } = useUser();
  const [cliente, setCliente] = useState("");
  const navigate = useNavigate();

  const carId = "6";

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

  const [selectedExterior, setSelectedExterior] = useState('azul');
  const [selectedInterior, setSelectedInterior] = useState('1');

    const images = {
        azul: {
          1: azul1,
          2: azul2,
          3: azul3,
        },
        rojo: {
          1: rojo1,
          2: rojo2,
          3: rojo3,
        },
        negro: {
            1: negro1,
            2: negro2,
            3: negro3,
        },
        blanco:{
            1: blanco1,
            2: blanco2,
            3: blanco3,
        }
      };

  const exteriorColors = [
    { name: 'negro', color: '#000000', precio: 1000003 },
    { name: 'azul', color: '#2E4A7B', precio: 2000003 },
    { name: 'rojo', color: '#961E1F', precio: 5000003 },
    { name: 'blanco', color: '#C0C0C0', precio: 2300003 },
  ];

  const interiorColors = [
    { name: '1', color: '#C0C0C0', precio: 4000000 },
    { name: '2', color: '#A9A9A9', precio: 10000000 },
    { name: '3', color: '#000000', precio: 20000000 },
  ];

  const calcularPrecioTotal = () => {
    let total = precioBase;
    exteriorColors.forEach(color => {
      if (color.name === selectedExterior) total += color.precio;
    });
    interiorColors.forEach(color => {
      if (color.name === selectedInterior) {total += color.precio;};
    });
    return total;
  };

  const calcularPrecioColores = () => {
    let total = 0;
    exteriorColors.forEach(color => {
      if (color.name === selectedExterior) total += color.precio;
    });
    interiorColors.forEach(color => {
      if (color.name === selectedInterior) {total += color.precio;};
    });
    return total;
  };

  


const facturar = () => {

  const total = calcularPrecioColores();
    
  const datosFacturacion = ({
    usuario: cliente,
    carroId: 6,
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
        <h2>Elige el color de las llantas</h2>
        <div className="color-options">
          {interiorColors.map(color => (
            <div
              key={color.name}
              className="color-option"
              style={{ backgroundColor: color.color }}
              onClick={() => setSelectedInterior(color.name)}
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

export default BMWX6M50i;