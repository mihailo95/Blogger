package rs.cubes.blogger.jsf.backing;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import rs.cubes.blogger.domain.Article;
import rs.cubes.blogger.domain.Comment;
import rs.cubes.blogger.service.ArticleService;
import rs.cubes.blogger.service.CommentService;

@Named
@SessionScoped
public class CommentBean implements Serializable {

	@Inject
	private UserBean ub;
	
	@Inject
	private ArticleCreatorBean aCb;
	
	@Inject
	private ArticleService aS;

	@Inject
	private CommentService cS;
	
	private Comment comment = new Comment();
	
	public CommentBean()
	{}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	
	private long identifikator;
	
	public long getIdentifikator() {
		return identifikator;
	}

	public void setIdentifikator(long identifikator) {
		this.identifikator = identifikator;
	}

	public String createComment ()
	{
		comment.setCreated(LocalDateTime.now());
		cS.createComment(comment, ub,identifikator);
		comment = new Comment();
		
		return "blogLogedIn.xhtml?faces-redirect=true";
	}
	
	public void getInd(long id)
	{
		identifikator = id ;
	}
	

	 List<Comment> comments;
	 
	 public void povuciIzBaze() {
		 comments = cS.getArticalComments((int) aCb.getNewArticle().getId());
	 }
	 
	 public List<Comment> list(){
		 povuciIzBaze();
		 return this.comments;
	 }

	
	
		//public List<Comment> list(){
		
		//return CommentService.getArticalComments((int) aCb.getNewArticle().getId());
			//}
		
		
		
		
	
}
