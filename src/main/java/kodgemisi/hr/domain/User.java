package kodgemisi.hr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.Table;

@Entity
@Table(name = "user")
=======

@Entity
>>>>>>> origin/master
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
<<<<<<< HEAD
	private Integer id;
=======
	private Integer userId;
>>>>>>> origin/master
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
<<<<<<< HEAD
	private String pass;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
=======
	private String password;
	
	public User(String username,String password){
		this.username = username;
		this.password = password;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
>>>>>>> origin/master
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
<<<<<<< HEAD
		return pass;
	}

	public void setPassword(String pass) {
		this.pass = pass;
=======
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
>>>>>>> origin/master
	}
	
	
}
