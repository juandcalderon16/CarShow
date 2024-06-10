import mazda from '../assets/images/Imagenes de muestra/cx5-blanca1-Photoroom.png-Photoroom.png';
import BMW from '../assets/images/Imagenes de muestra/bmw-azul4-Photoroom.png';
import { useNavigate } from "react-router-dom";

const Camionetas = () => {

        const navigate = useNavigate();


        return (

            <div>
               
                <div className="camionetas">
                    <h1>Camionetas</h1>

                    <div className="car-display" >
                        <img src={mazda} alt="cx5-azul" onClick={() => navigate('/PersoMazda')}/>
                        <div className="car-info" >
                            <h2>Mazda Cx-5 2024</h2>
                            <p>Precio: $150,000,000</p>
                        </div>
                    </div>

                    <div className="car-display">
                        <img src={BMW} alt="bmw-azul" onClick={() => navigate('/BMWX6M50i')}/>
                        <div className="car-info">
                            <h2>BMW X6 M50i 2024</h2>
                            <p>Price: $549,900,000</p>
                        </div>
                    </div>
                </div>
            </div>

        );
}
export default Camionetas;