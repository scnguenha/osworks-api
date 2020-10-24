package mz.co.scntech.osworks.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mz.co.scntech.osworks.domain.model.Cliente;

/**
 * 
 * @author Sidónio Goenha on 22/10/2020
 *
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente> findByNome(String nome);
	List<Cliente> findByNomeContaining(String nome);
	Cliente findByEmail(String email);
	
}
