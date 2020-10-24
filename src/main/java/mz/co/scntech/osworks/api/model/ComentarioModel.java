package mz.co.scntech.osworks.api.model;

import java.time.OffsetDateTime;

/**
 * 
 * @author Sidónio Goenha on 23/10/2020
 *
 */
public class ComentarioModel {
	private Long id;
	private String descricao;
	private OffsetDateTime dataEnvio;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public OffsetDateTime getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(OffsetDateTime dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	
	
}
