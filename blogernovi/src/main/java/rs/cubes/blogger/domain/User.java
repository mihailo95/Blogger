package rs.cubes.blogger.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	
	@NotNull
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
	        +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
	        +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	        message="Pogresan email")
	private String email;
	
	@Size(min = 5, max = 25)
	private String surname;
	
	@Size(min = 5, max = 25)
	private String nickname;
	
	@NotNull
    @Size(min = 5, max = 25)
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String name;
	
	@Size(min = 5, max=12 , message = "Age must be between {min} and {max}")
	private String password;

	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<Article> articles = new ArrayList<>();
	
	@OneToMany(mappedBy="user")
	private Set<Rating> ratings;
	
	
	@OneToMany(mappedBy="author")
	private Set<Comment> comments;
	
	
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}

	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}

	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getSurname() {return surname;}
	public void setSurname(String surname) {this.surname = surname;}

	
	
	public String getNickname() {return nickname;}
	public void setNickname(String nickname) {this.nickname = nickname;}

	
	
	public List<Article> getArticles() {return articles;}
	public void setArticles(List<Article> articles) {this.articles = articles;}

	public Set<Rating> getRatings() {return ratings;}
	public void setRatings(Set<Rating> ratings) {this.ratings = ratings;}

	public Set<Comment> getComments() {return comments;}
	public void setComments(Set<Comment> comments) {this.comments = comments;}
}
