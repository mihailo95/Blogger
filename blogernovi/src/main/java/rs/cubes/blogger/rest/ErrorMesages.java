package rs.cubes.blogger.rest;

public class ErrorMesages {
	
	private int code;
	
	private String message;
	
	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private ErrorMesages(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public static final ErrorMesages ok = new ErrorMesages(0, "Operation successfull");
	
	public static final ErrorMesages db_problem = new ErrorMesages(100, "Database error");
	
	public static final ErrorMesages invalid_query_string = new ErrorMesages(103, "Query string is not properly formed.");

	public static final ErrorMesages resource_dont_exist = new ErrorMesages(104, "Resource with given id does not exist.");
	
	public static final ErrorMesages size_out_bounds = new ErrorMesages(105, "Attribute length invalid.");
	
	public static final ErrorMesages wrong_email_format = new ErrorMesages(106, "String is not valid email address.");
	
	public static final ErrorMesages email_already_exists = new ErrorMesages(107, "Email in db exists.");
	
	public static final ErrorMesages username_exists = new ErrorMesages(108,  "Username already taken.");
}
