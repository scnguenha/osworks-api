package mz.co.scntech.osworks.api.model;

import javax.validation.constraints.NotBlank;

/**
 * 
 * @author Sidónio Goenha on 23/10/2020
 *
 */
public class ComentarioInput {

	@NotBlank
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
