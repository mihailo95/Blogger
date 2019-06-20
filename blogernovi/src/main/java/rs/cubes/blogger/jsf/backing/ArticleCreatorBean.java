package rs.cubes.blogger.jsf.backing;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import rs.cubes.blogger.domain.Article;
import rs.cubes.blogger.service.ArticleService;

@Named
@SessionScoped
public class ArticleCreatorBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	ArticleService aS;
	@Inject
	private UserBean ub;
	
	private Article newArticle = new Article();
	
	//@PostConstruct
    //public void initNewArticle() {
       // newArticle = new Article();
    //}
	
	public ArticleCreatorBean() {}
	
	public Article getNewArticle() {
		return newArticle;
	}
	
	public void setNewArticle(Article newArticle) 
	{
		this.newArticle = newArticle;
		}

	
	
	
	public String createArticle()
	{	
		newArticle.setCreated(LocalDateTime.now());
		aS.createArticle(newArticle, ub);
		//initNewArticle();
		newArticle= new Article();
		return "blogLogedIn.xhtml?faces-redirect=true";
		
	}
	
	private Article ByIdfoundArticle = new Article();
	
	public Article doFindArticleById(long id)
	{
		ByIdfoundArticle = aS.getArticle(id);
		return ByIdfoundArticle;
	}
	
	
}


