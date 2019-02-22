package com.roberto.jpa.sysnews.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "adnews")
@NamedQuery(name = "Adnew.findAll", query = "SELECT ad FROM Adnew ad")
public class Adnew extends AuditModel {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,
					generator = "native")
	@Column(name = "id")
	private Long id;
	
	@NotNull(message = "This field can not be null. Please again.")
	@Size(max = 255)
	@Column(name = "title")
	private String title;
	
	@NotNull(message = "This field can not be null. Please again.")
	@Lob
	@Column(name = "description")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@OneToMany(mappedBy = "adnew", cascade = CascadeType.ALL, targetEntity = Comment.class)
	private List<Comment> comments = new ArrayList<>();
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	@Override
	public String toString() {
		return "Adnew [id=" + id + ", title=" + title + ", description=" + description + ", user=" + user
				+ ", comments=" + comments + "]";
	}
	
	
	
	
}
