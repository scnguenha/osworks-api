package mz.co.scntech.osworks.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.co.scntech.osworks.domain.exception.EntidadeNãoEncontradaException;
import mz.co.scntech.osworks.domain.exception.NegocioException;
import mz.co.scntech.osworks.domain.model.Comentario;
import mz.co.scntech.osworks.domain.model.OrdemServico;
import mz.co.scntech.osworks.domain.model.StatusOrdemServico;
import mz.co.scntech.osworks.domain.repository.ClienteRepository;
import mz.co.scntech.osworks.domain.repository.ComentarioRepository;
import mz.co.scntech.osworks.domain.repository.OrdemServicoRepository;

/**
 * 
 * @author Sidónio Goenha on 23/10/2020
 *
 */
@Service
public class GestaoOrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ComentarioRepository comentarioRepository;

	public OrdemServico criar(OrdemServico ordemServico) {
		var cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));

		ordemServico.setCliente(cliente);

		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());

		return ordemServicoRepository.save(ordemServico);
	}

	public void finalizar(Long ordemServicoId) {
		var ordemServico = buscar(ordemServicoId);
		
		ordemServico.finalizar();
		
		ordemServicoRepository.save(ordemServico);
	}

	private OrdemServico buscar(Long ordemServicoId) {
		return ordemServicoRepository.findById(ordemServicoId)
				.orElseThrow(() -> new EntidadeNãoEncontradaException("Ordem de serviço não encontrada"));
	}

	public Comentario adicionarComentario(Long ordemServicoId, String descricao) {
		var ordemServico = buscar(ordemServicoId);

		var comentario = new Comentario();
		comentario.setDataEnvio(OffsetDateTime.now());
		comentario.setDescricao(descricao);
		comentario.setOrdemServico(ordemServico);

		return comentarioRepository.save(comentario);
	}
}
