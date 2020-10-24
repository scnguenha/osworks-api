package mz.co.scntech.osworks.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import mz.co.scntech.osworks.api.model.ComentarioInput;
import mz.co.scntech.osworks.api.model.ComentarioModel;
import mz.co.scntech.osworks.domain.exception.EntidadeNãoEncontradaException;
import mz.co.scntech.osworks.domain.model.Comentario;
import mz.co.scntech.osworks.domain.repository.OrdemServicoRepository;
import mz.co.scntech.osworks.domain.service.GestaoOrdemServicoService;

/**
 * 
 * @author Sidónio Goenha on 23/10/2020
 *
 */
@RestController
@RequestMapping("/ordens-servico/{ordemServicoId}/comentarios")
public class ComentarioController {

	@Autowired
	private GestaoOrdemServicoService gestaoOrdemServico;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@GetMapping
	public List<ComentarioModel> listar(@PathVariable Long ordemServicoId) {
		var ordemServico = ordemServicoRepository.findById(ordemServicoId)
				.orElseThrow(() -> new EntidadeNãoEncontradaException("Ordem de serviço não encontrada"));

		return toCollectionModel(ordemServico.getComentarios());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ComentarioModel adicionr(@PathVariable Long ordemServicoId,
			@Valid @RequestBody ComentarioInput comentarioInput) {

		var comentario = gestaoOrdemServico.adicionarComentario(ordemServicoId, comentarioInput.getDescricao());

		return toModel(comentario);
	}

	private ComentarioModel toModel(Comentario comentario) {
		return modelMapper.map(comentario, ComentarioModel.class);
	}

	private List<ComentarioModel> toCollectionModel(List<Comentario> comentarios) {
		return comentarios.stream().map(comentario -> toModel(comentario)).collect(Collectors.toList());
	}
}
