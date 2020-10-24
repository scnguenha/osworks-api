package mz.co.scntech.osworks.api.model;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author Sidónio Goenha on 23/10/2020
 *
 */
public class ClienteIdInput {
	
	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
