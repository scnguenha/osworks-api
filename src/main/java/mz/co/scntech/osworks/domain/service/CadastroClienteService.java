package mz.co.scntech.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.co.scntech.osworks.domain.exception.NegocioException;
import mz.co.scntech.osworks.domain.model.Cliente;
import mz.co.scntech.osworks.domain.repository.ClienteRepository;

/**
 * 
 * @author Sidónio Goenha on 22/10/2020
 *
 */
@Service
public class CadastroClienteService { 
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		
		if (clienteExistente !=null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}
