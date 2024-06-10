import { Component } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";

import Facturacion from "./components/Facturacion";
import IniciarSesion from "./components/IniciarSesion";
import CrearPerfil from './components/CrearPerfil';
import SesionIniciada from "./components/SesionIniciada";
import RouterController from "./RouterController";
import Home from "./components/Home";
import CarColorPicker from "./components/CarColorPicker";
import BMWM3 from "./components/BMWM3";
import BMWX6M50i from "./components/BMW-X6-M50i";
import SupraMk5 from "./components/SupraMk5";
import Miata from "./components/Miata";





class Router extends Component {

    render() {

        return (


            <BrowserRouter>



                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/IniciarSesion" element={<IniciarSesion />} />
                    <Route path="/PersoMazda" element={<RouterController component={CarColorPicker} />} />
                    <Route path="/SesionIniciada" element={<RouterController component={SesionIniciada} />}/>
                    <Route path="/Facturacion" element={<RouterController component={Facturacion} />}/>
                    <Route path="/CrearPerfil" element={<CrearPerfil />} Routes/>
                    <Route path="/BMWM3" element={<RouterController component={BMWM3} />}/>
                    <Route path="/BMWX6M50i" element={<RouterController component={BMWX6M50i} />}/>
                    <Route path="/SupraMk5" element={<RouterController component={SupraMk5} />}/>
                    <Route path="/Miata" element={<RouterController component={Miata} />}/>



                </Routes>

            </BrowserRouter>


        );
    }
}
export default Router;