package rs.cubes.blogger.service;

import javax.ejb.ApplicationException;

import rs.cubes.blogger.rest.ErrorMesages;

@ApplicationException(rollback = true)
public class AppException extends RuntimeException {
	
	private ErrorMesages error;
	
	
	public ErrorMesages getError() {
		return error;
	}



	public void setError(ErrorMesages error) {
		this.error = error;
	}



	public AppException(ErrorMesages error) {
		this.error = error;
	}

}
