package rs.cubes.blogger.domain.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import rs.cubes.blogger.domain.Comment;

public class CommentQueries {

	public static List<Comment> getCommentsByArtical(EntityManager em, int id){
		
		String q = "select c from Comment c where c.article_id =:id";
		
		TypedQuery<Comment> querry = em.createQuery(q, Comment.class);
		querry.setParameter("id", id);
		
		List<Comment> list = querry.getResultList();
			
	if(list.isEmpty()) {return null;}
		
		return (List<Comment>) list.get(0);
	}
	


	public static Comment getCommentById(EntityManager em, int id) {
		
		Comment comment = em.find(Comment.class, id);
		
		return comment;
	}
}
