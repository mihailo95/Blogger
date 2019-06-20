package rs.cubes.blogger.rest;

import javax.ejb.EJB;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;



import rs.cubes.blogger.domain.User;
import rs.cubes.blogger.service.AppException;
import rs.cubes.blogger.service.UserService;

@Path("/user")
public class UserResource {
	
	
	
	@EJB
	private UserService userService;
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public UserResponse createUser(User user) {
		
		UserResponse response = new UserResponse();
		
		try {
			//Category c = categoryService.createCategory(category);
			User u = userService.createUser(user);
			
			response.setUser(u);
			//response.setCode(ErrorMesages.ok.getCode());
			//response.setErrorMessage(ErrorMesages.ok.getMessage());
			response.setErrorCode(ErrorMesages.ok);
			
			return response;
			
		} catch(PersistenceException pe) {
			
			//response.setCode(ErrorMesages.db_problem.getCode());
			//response.setErrorMessage(ErrorMesages.db_problem.getMessage());
			response.setErrorCode(ErrorMesages.db_problem);
			return response;
			
		} catch(AppException appEx) {
			
			response.setErrorCode(appEx.getError());
			return response;
		}
		
	}

}
