package mz.co.scntech.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mz.co.scntech.osworks.domain.model.Cliente;

/**
 * 
 * @author Sidónio Goenha on 21/10/2020
 *
 */
@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente("João", "joao@scntech.com", "846791232");
		var cliente2 = new Cliente("Maria", "mariacacilda@scntech.com", "864567098");
		var cliente3 = new Cliente("Sidy Nguenha", "sid.goenha@gmail.com", "842168777");
	
		return Arrays.asList(cliente1, cliente2, cliente3);
	}
}
