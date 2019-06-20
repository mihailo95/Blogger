package rs.cubes.blogger.jsf.backing;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import rs.cubes.blogger.domain.User;
import rs.cubes.blogger.service.UserService;
import rs.cubes.blogger.utils.Util;
import java.io.Serializable;

@Named
@SessionScoped
public class UserBean implements Serializable{ 
	
	private static final long serialVersionUID = 1L;
		
	    @Inject
	    private UserService uS;
	    
	    private User user = new User();
	    
	    private String name, password;
	    
	    //@PostConstruct
	    //public void initNewUser() {
	     //   user = new User();
	   // }
	    
	    public UserBean() {
			
		}

		public void register() throws Exception {
	        try {
	        	uS.createUser(user);
	            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
	            
	            user = new User();
	        } catch (Exception e) {
	            String errorMessage = getRootErrorMessage(e);
	            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
	           
	        }
	    }
		
		public String log() {
			
	        if (uS.saveUserState(name, password) == true) {
	        	HttpSession session = Util.getSession();
	            session.setAttribute("name", name);
	            user = uS.getUserByUserName();
	            
	            return "blogLogedIn.xhtml?faces-redirect=true";	            
	        } else {
	            return "login.xhtml?faces-redirect=true";	        }
	    }
	
	public String logout() {
	      HttpSession session = Util.getSession();
	      session.invalidate();
	      return "blog?faces-redirect=true";
	   }
	
	

	    private String getRootErrorMessage(Exception e) {
	        
	        String errorMessage = "Registration failed. See server log for more information";
	        if (e == null) {
	        
	            return errorMessage;
	        }

	     
	        Throwable t = e;
	        while (t != null) {
	         
	            errorMessage = t.getLocalizedMessage();
	            t = t.getCause();
	        }
	     
	        return errorMessage;
	    }



	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
		}
