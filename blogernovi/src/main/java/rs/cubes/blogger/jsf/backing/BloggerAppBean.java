package rs.cubes.blogger.jsf.backing;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import rs.cubes.blogger.domain.Article;
import rs.cubes.blogger.service.ArticleService;

@Named
@ApplicationScoped
public class BloggerAppBean {
	
	
	@Inject
	private ArticleService aS;
	

	List<Article> articles;
	
	
	public void povuciIzBaze()
	{
		articles = aS.getArticles();
		
	}
	 public List<Article> order (){
		 povuciIzBaze();
		return this.articles;
		
	 }
	

}
