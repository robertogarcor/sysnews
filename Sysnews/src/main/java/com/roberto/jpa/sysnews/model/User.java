package com.roberto.jpa.sysnews.model;

import java.util.ArrayList;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class Model User
 * @author Roberto
 * @version 23 feb. 2019 11:19:11
 */

@Entity
@Table(name = "users")
@JsonIgnoreProperties(
		value  = {"createdAt", "updatedAt", "password", "isAdmin"},
		allowSetters = true
)
@NamedQuery(name = "User.ckeckLogin", query = "SELECT u FROM User u WHERE username=?1 AND password=?2")
public class User extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, 
					generator = "native")
	@Column(name = "id")
	private Long id;
	
	@NotEmpty(message = "This field can not be null. Please again.")
	@NotNull(message = "This field can not be null. Please again.")
	@Column(name = "username", length = 50, unique = true, nullable = false)
	private String username;
	
	@NotEmpty(message = "This field can not be null. Please again.")
	@NotNull(message = "This field can not be null. Please again.")
	@Column(name = "password", nullable = false)
	@JsonProperty("password")
	private String password;

	@Column(name = "first_name", length = 50)
	private String first_name;
	
	@Column(name = "last_name", length = 50)
	private String last_name;
	
	@NotEmpty(message = "This field can not be null. Please again.")
	@NotNull(message = "This field can not be null. Please again.")
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "description", length = 255)
	private String description;
	
	// Default fetch is: FetchType.LAZY
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, targetEntity = Adnew.class)
	private List<Adnew> adnews = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, targetEntity= Comment.class)
	private List<Comment> comments = new ArrayList<>();
	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getDescription() {
		
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", email=" + email + ", image=" + image + ", description=" + description
				+ ", adnews=" + adnews + "]";
	}
	
}
