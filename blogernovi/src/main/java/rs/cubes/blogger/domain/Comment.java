package rs.cubes.blogger.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Comment {

	
	@Id
	@GeneratedValue
	private long id;
	private LocalDateTime created;
	private String text;
	private int upVote;
	private int downVote;
	
	@ManyToOne
	private Article article;
	
	@ManyToOne
	private User author;
	
	
	
	public Comment() {}

	public long getId() {return id;}
	public void setId(long id) {this.id = id;}

	public LocalDateTime getCreated() {return created;}
	public void setCreated(LocalDateTime created) {this.created = created;}

	public String getText() {return text;}
	public void setText(String text) {this.text = text;}

	public int getUpVote() {return upVote;}
	public void setUpVote(int upVote) {this.upVote = upVote;}

	public int getDownVote() {return downVote;}
	public void setDownVote(int downVote) {this.downVote = downVote;}

	public Article getArticle() {return article;}
	public void setArticle(Article article) {this.article = article;}

	public User getAuthor() {return author;}
	public void setAuthor(User author) {this.author = author;}

	
}
