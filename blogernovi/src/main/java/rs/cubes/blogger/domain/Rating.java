package rs.cubes.blogger.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rating {
	
	
	@Id
	@GeneratedValue
	private long id;
	private int rating;
	
	@ManyToOne
	private Article article;
	
	@ManyToOne
	private User user;

	public Rating() {}

	public long getId() {return id;}
	public void setId(long id) {this.id = id;}

	public int getRating() {return rating;}
	public void setRating(int rating) {this.rating = rating;}

	public Article getArticle() {return article;}
	public void setArticle(Article article) {this.article = article;}

	public User getUser() {return user;}
	public void setUser(User user) {this.user = user;}

}
