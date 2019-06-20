package rs.cubes.blogger.service;


import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import rs.cubes.blogger.jsf.backing.UserBean;
import rs.cubes.blogger.rest.ErrorMesages;
import rs.cubes.blogger.service.AppException;
import rs.cubes.blogger.utils.EmailRegEX;
import rs.cubes.blogger.domain.User;
import rs.cubes.blogger.domain.jpa.UserQueries;



@Stateless
public class UserService { 
	
	@PersistenceContext
	public EntityManager em;
	
	@Inject
	private UserBean ub;
		 
	private boolean t = false;
	
	public boolean saveUserState(String name, String password) {
	    // 1-Send query to database to see if that user exist
	    Query query = em
	        .createQuery("SELECT u FROM User u WHERE u.name=:name and u.password=:password");
	    query.setParameter("name", name);
	    query.setParameter("password", password);
	    // 2-If the query returns the user(Role) object, store it somewhere in
	    // the session
	    
	    try {
	        User user = (User) query.getSingleResult();	        
	        if (user != null && user.getName().equals(name)
	            && user.getPassword().equals(password)) {
	            FacesContext.getCurrentInstance().getExternalContext()
	                .getSessionMap().put("user", user);
	            t= true;
	            // 3-return true if the user state was saved
	            System.out.println(user.getName() + user.getPassword());
	            return t;
	        }
	    } catch (Exception e) {
	        // This fix the bug that does not display the message when wrong
	        // password!
	    	
	        FacesMessage msg = new FacesMessage("Pogresan email ili lozinka");
	        }
	   
	    
	    // 4-return false otherwise
	    return false;
	}
	
	
	public User getUser(String name, String password) {
		try { 
			User user = (User) em .createQuery( "SELECT u from User u where u.name = :name and u.password = :password") 
					.setParameter("name", name) 
					.setParameter("password", password).getSingleResult(); 
			return user; 
			}
		catch (NoResultException e) { 
			return null; 
		} 
		} 
	
	public User getUserByUserName() {
		
		return UserQueries.findByUsername(em, ub.getName());
	}
	
public User createUser(User user) {
		
		checkLength(user.getName(), 50);
		checkLength(user.getSurname(), 60);
		
		if( !EmailRegEX.validate(user.getEmail())) {
			throw new AppException(ErrorMesages.wrong_email_format);
		}
		/////////////////////////////////////////////////////////////
		if(UserQueries.emailExists(em, user.getEmail())) {
			throw new AppException(ErrorMesages.email_already_exists);
		}
		
		if(UserQueries.usernameExists(em, user.getUsername())) {
			throw new AppException(ErrorMesages.username_exists);
		}
		
		em.persist(user);
		
		
		return user;
	}
private void checkLength(String target, int maxLength) {
	
	if(target != null && target.length() > maxLength) {
		throw new AppException(ErrorMesages.size_out_bounds);
	}
}
	
public boolean deletarUser(User user) 
{ 
	try { em.remove(user); return true; 
} 
catch (Exception e) 
	{
	e.printStackTrace(); return false; 
	}
	} 


	

}



