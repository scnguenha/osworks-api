package mz.co.scntech.osworks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mz.co.scntech.osworks.domain.model.Comentario;

/**
 * 
 * @author Sidónio Goenha on 23/10/2020
 *
 */

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
