import mazda from '../assets/images/Imagenes de muestra/1-removebg.png';
import BMW from '../assets/images/Imagenes de muestra/BMW m3 competition.png';
import supra from '../assets/images/Imagenes de muestra/2.png'
import { useNavigate } from "react-router-dom";

const Deportivos = () => {

        const navigate = useNavigate();


        return (

            <div>
               
                <div className="deportivos">
                    <h1 id='titulo-deportivos'>Deportivos</h1>

                    <div className="car-display" >
                        <img src={mazda} alt="cx5-azul" onClick={() => navigate('/Miata')}/>
                        <div className="car-info" >
                            <h2>Mazda Mx-5 miata 2024</h2>
                            <p>Precio: $182.250. 000</p>
                        </div>
                    </div>

                    <div className="car-display">
                        <img src={BMW} alt="bmw-azul" onClick={() => navigate('/BMWM3')}/>
                        <div className="car-info">
                            <h2>BMW M3 Competition</h2>
                            <p>Price: $549,900,000</p>
                        </div>

                        
                    </div>
                    <div className="car-display" id='supra'>
                        <img src={supra} alt="bmw-azul" onClick={() => navigate('/SupraMk5')}/>
                        <div className="car-info">
                            <h2>Toyota Supra MK5 2024</h2>
                            <p>Price: $549,900,000</p>
                        </div>

                        
                    </div>
                </div>
            </div>

        );
}
export default Deportivos;