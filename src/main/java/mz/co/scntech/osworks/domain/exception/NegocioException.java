package mz.co.scntech.osworks.domain.exception;

/**
 * 
 * @author Sidónio Goenha on 22/10/2020
 *
 */
public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = -3241525138103073219L;

	public NegocioException(String message) {
		super(message);
	}

}
