package rs.cubes.blogger.rest;

import rs.cubes.blogger.domain.User;

public class UserResponse extends RESTResponse {
	
	
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
