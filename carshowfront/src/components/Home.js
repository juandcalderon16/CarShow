import mazda from '../assets/images/Imagenes de muestra/cx5-blanca1-Photoroom.png-Photoroom.png';
import { useNavigate } from "react-router-dom";
import Header from './Header';
import Camionetas from './Camionetas';
import Deportivos from './Deportivos';

const Home = () => {

    const navigate = useNavigate()

    return (
        <div>
            <Header />
            <Camionetas />
            <Deportivos />
        </div>
    );
}
export default Home;