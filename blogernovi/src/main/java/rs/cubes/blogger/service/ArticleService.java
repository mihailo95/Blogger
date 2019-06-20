package rs.cubes.blogger.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import rs.cubes.blogger.domain.Article;
import rs.cubes.blogger.domain.User;
import rs.cubes.blogger.jsf.backing.UserBean;


@Stateless
public class ArticleService {

	
	@PersistenceContext
	public EntityManager em;
	

	public Article createArticle(Article article, UserBean u) {
		
		article.setUser(u.getUser());
		em.persist(article);
		
		//user = em.merge(user);
		
		//article.setAuthor(user);
		
		//user.getArticles().add(article);
		
		return article;
	}
	
	
	
	public Article getArticle(long id) 
	{
		try { 
			Article article= (Article) em .createQuery( "SELECT a from Article a where a.id = :id") 
					.setParameter("id", id).getSingleResult();
			return article; 
			}
		catch (NoResultException e) 
			{ 
			return null; 
			} 
	}
	

	public List<Article>  getArticles() {
		try { 
			TypedQuery<Article> articles= em .createQuery( "SELECT a from Article a ", Article.class);
			return articles.getResultList();
			}
		catch (NoResultException e) { 
			return null; 
		} 
		}
	
	
	
	
	

	
}
