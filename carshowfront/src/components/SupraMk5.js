import React, { useState, useEffect } from 'react';
import CarController from './CarController';
import { useUser } from './UserContext';
import { useNavigate } from "react-router-dom";


import s11 from '../assets/images/supra/s11.png';
import s12 from '../assets/images/supra/s12.png';
import s13 from '../assets/images/supra/s13.png';
import s21 from '../assets/images/supra/s21.png';
import s22 from '../assets/images/supra/s22.png';
import s23 from '../assets/images/supra/s23.png';
import s31 from '../assets/images/supra/s31.png';
import s32 from '../assets/images/supra/s32.png';
import s33 from '../assets/images/supra/s33.png';
import s41 from '../assets/images/supra/s41.png';
import s42 from '../assets/images/supra/s42.png';
import s43 from '../assets/images/supra/s43.png';
import s51 from '../assets/images/supra/s51.png';
import s52 from '../assets/images/supra/s52.png';
import s53 from '../assets/images/supra/s53.png';
import HeaderSesionON from './Header/HeaderSesionOn';
import axios from 'axios';
import userEvent from '@testing-library/user-event';
  
const SupraMk5 = () => {



  const [precioBase, setBasePrice] = useState(0);
  const [nombreCarro, setNombreCarro] = useState("");
  const [colorPrices, setColorPrices] = useState();
  const { user } = useUser();
  const [cliente, setCliente] = useState("");
  const navigate = useNavigate();

  const carId = "7";

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
      1: s11,
      2: s12,
      3: s13,
    },
    s2: {
      1: s21,
      2: s22,
      3: s23,
    },
    s3: {
      1: s31,
      2: s32,
      3: s33,
    },
    s4: {
        1: s41,
        2: s42,
        3: s43,
      },
      s5: {
        1: s51,
        2: s52,
        3: s53
      }
  };

  const exteriorColors = [
    { name: 's1', color: '#2E4A7B', precio: 1000001 },
    { name: 's2', color: '#C0C0C0', precio: 2000001 },
    { name: 's3', color: '#000000', precio: 1500001 },
    { name: 's4', color: '#e32719', precio: 3000001 },
    { name: 's5', color: '#ff8c00', precio: 2400001 },
  ];

  const interiorColors = [
    { name: '1', color: '#C0C0C0', precio: 4000000 },
    { name: '2', color: '#A9A9A9', precio: 10000000 },
    { name: '3', color: '#000000', precio: 13000000 },
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
    carroId: 7,
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

export default SupraMk5;