package rs.cubes.blogger.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RESTResponse {
	
	private int code;
	
	private String errorMessage;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public void setErrorCode(ErrorMesages em) {
		this.setCode(em.getCode());
		this.setErrorMessage(em.getMessage());
	}

}
