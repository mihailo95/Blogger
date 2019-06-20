package rs.cubes.blogger.domain;


import java.time.LocalDateTime;
import java.util.Set;

import javax.enterprise.inject.Typed;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;


@Entity
public class Article {
	
	
	@Id
	@GeneratedValue
	private long id;
	private String title;
	
	
	@Size(min = 5, max = 5000)
	
	private String content;
	private LocalDateTime created;
	
	@ElementCollection
	private Set<String> keywords;
	private int ratingCounter;
	private double averageCounter;
	
	@OneToMany(mappedBy="article")
	private Set<Rating> ratings;
	
	@ManyToMany
	private Set<Tag> tags;
	
	@OneToMany(mappedBy="article")
	private Set<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name="AUTHOR_ID")
	private User user;
	
	public Article() {}

	public long getId() {return id;}
	public void setId(long id) {this.id = id;}

	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}

	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}

	public LocalDateTime getCreated() {return created;}
	public void setCreated(LocalDateTime created) {this.created = created;}

	public Set<String> getKeywords() {return keywords;}
	public void setKeywords(Set<String> keywords) {this.keywords = keywords;}

	public int getRatingCounter() {return ratingCounter;}
	public void setRatingCounter(int ratingCounter) {this.ratingCounter = ratingCounter;}

	public double getAverageCounter() {return averageCounter;}
	public void setAverageCounter(double averageCounter) {this.averageCounter = averageCounter;}

	public Set<Rating> getRatings() {return ratings;}
	public void setRatings(Set<Rating> ratings) {this.ratings = ratings;}

	public Set<Tag> getTags() {return tags;}
	public void setTags(Set<Tag> tags) {this.tags = tags;}

	public Set<Comment> getComments() {return comments;}
	public void setComments(Set<Comment> comments) {this.comments = comments;}

	public User getUser() {return user;}
	public void setUser(User user) {this.user = user;}
}
