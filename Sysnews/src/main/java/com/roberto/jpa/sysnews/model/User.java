package com.roberto.jpa.sysnews.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, 
					generator = "native")
	private Long id;
	
	@NotNull(message = "This field can not be null. Please again.")
	@Size(max = 50)
	@Column(unique = true)
	private String username;
	
	@NotNull(message = "This field can not be null. Please again.")
	private String password;

	@Size(max = 50)
	private String first_name;
	
	@Size(max = 50)
	private String last_name;
	
	@NotNull(message = "This field can not be null. Please again.")
	@Column(unique = true)
	private String email;
	
	private String image;
	
	@Size(max = 256)
	private String description;
	
	
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
	
	
}
