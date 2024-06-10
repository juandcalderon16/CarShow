import axios from "axios";

const CARRO_BASE_REST_API_URL = "http://localhost:8080/api";


class CarController {

    getPrecioCarro(carroId){
        return axios.get(CARRO_BASE_REST_API_URL + '/base-price/' + carroId);
    }
    getCarroName(carroId){
        return axios.get(CARRO_BASE_REST_API_URL + '/carroName/' + carroId);
    }
} 

export default new CarController();