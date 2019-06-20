package rs.cubes.blogger.domain.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import rs.cubes.blogger.domain.User;


public class UserQueries {
	
	public static boolean emailExists(EntityManager em, String email) {
		
		String q = "select u from User u where u.email = :email";
		
		TypedQuery<User> query = em.createQuery(q, User.class);
		query.setParameter("email", email);
		
		List<User> users = query.getResultList();
		
		if( users.size() == 0) 
			{return false;}
		else 					
			{return true;}
	}
	
	public static boolean usernameExists(EntityManager em , String username) {
		
		String q = "select u from User u where u.username = :username";
		
		TypedQuery<User> query = em.createQuery(q, User.class);
		query.setParameter("username", username);
		
		List<User> users = query.getResultList();
		

		if( users.size() == 0) {
			return false;
		} else {
			return true;
		}
		
	}
	
	
	public static User findByUsername(EntityManager em, String name) {
		
		String q = "select u from User u where u.name =:name";
		
		TypedQuery<User> querry = em.createQuery(q, User.class);
		querry.setParameter("name", name);
		
		List<User> list = querry.getResultList();
		
		if(list.isEmpty()) {return null;}
		
		return list.get(0);
}

}
