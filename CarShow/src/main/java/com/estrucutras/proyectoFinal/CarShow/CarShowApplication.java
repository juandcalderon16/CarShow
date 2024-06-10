package com.estrucutras.proyectoFinal.CarShow;

import com.estrucutras.proyectoFinal.CarShow.entities.Carro;
import com.estrucutras.proyectoFinal.CarShow.entities.Cliente;
import com.estrucutras.proyectoFinal.CarShow.entities.Proveedor;
import com.estrucutras.proyectoFinal.CarShow.repository.ClienteRepository;
import com.estrucutras.proyectoFinal.CarShow.services.CarroService;
import com.estrucutras.proyectoFinal.CarShow.services.ClienteService;
import com.estrucutras.proyectoFinal.CarShow.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@SpringBootApplication
public class CarShowApplication implements CommandLineRunner {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private CarroService carroService;

	@Autowired
	private ProveedorService proveedorService;

	public static void main(String[] args) {
		SpringApplication.run(CarShowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		//clienteService.crearCliente(new Cliente("pañales","1234",22,"edea","ewew"));
		Proveedor proveedor = proveedorService.obtenerPorId(4L);
		//clienteService.crearCliente(new Cliente("estoa","123"));
		//Proveedor proveedor = proveedorService.ingresarProveedor(new Proveedor("Mazda CasaToro"));
		//carroService.ingresarCarro(new Carro("M3 Competition 2023", "2023", "BMW", 474900000, proveedor));
		//carroService.ingresarCarro(new Carro("X6 M50i 2023", "2023", "BMW", 549900000, proveedor));
		//clienteService.eliminarCliente(0L);
		System.out.println(carroService.buscarCarroPorId(3L).getPrecio());
		System.out.println("numero de personas en la tabla es: " + carroService.contarCarros());
		List<Carro> carro = carroService.getCarros();
		carro.forEach(p -> System.out.println("Nombre de usuario del cliente: " + p.getReferencia() + p.getId_carro()));
	}

}
