import React,{Component} from "react";
import HeaderSesionON from "./Header/HeaderSesionOn";
import CarColorPicker from "./CarColorPicker";
import Camionetas from "./Camionetas";
import Deportivos from "./Deportivos";

class SesionIniciada extends Component {
    render() {
        return(
            <div>
                <HeaderSesionON />
                
                <Camionetas />

                <Deportivos />
            </div>
        );
    }
}
export default SesionIniciada;