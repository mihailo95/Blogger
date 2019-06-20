package rs.cubes.blogger.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import rs.cubes.blogger.domain.Comment;
import rs.cubes.blogger.domain.jpa.CommentQueries;
import rs.cubes.blogger.jsf.backing.ArticleCreatorBean;

import rs.cubes.blogger.jsf.backing.UserBean;


@Stateless
public class CommentService {
	

	@Inject
	private UserBean uB;
	@Inject
	private ArticleCreatorBean aCb;
	
	@PersistenceContext
	private static EntityManager em;
	
	public Comment createComment(Comment comment,UserBean uB, long identifikator ) {
		
		comment.setAuthor(uB.getUser());
		comment.setArticle(aCb.doFindArticleById(identifikator));	
		//em.merge(comment);
		em.persist(comment);
		
		return comment;
	}


	
	
	public static List<Comment> getArticalComments(int article_id) {
		
		return CommentQueries.getCommentsByArtical(em, article_id);
	}

	public List<Comment>  getCommentsByArticle(long article_id) {
		try { 
			TypedQuery<Comment> comments= (TypedQuery<Comment>) em.createQuery( "SELECT c from Comment c where c.article_id = :article_id").setParameter("article_id", article_id)
.getResultList();
			List<Comment> list = comments.getResultList();
			
			return list;
			}
		catch (NoResultException e) { 
			return null; 
		} 
		}
	public List<Comment>  getCommentsByUser(long user_id) {
		try { 
			TypedQuery<Comment> comments= (TypedQuery<Comment>) em.createQuery( "SELECT c from Comment c where c.user_id = :user_id").setParameter("user_id", user_id)
.getResultList();
			return comments.getResultList();
			}
		catch (NoResultException e) { 
			return null; 
		} 
		}
	
	
	

	

}
