package com.roberto.jpa.sysnews.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Class Model Token
 * @author Roberto
 * @version 3 mar. 2019 22:01:22
 */


@Entity
@Table(name = "tokens")
@NamedQueries({
	@NamedQuery(name = "Token.delete",
				query = "DELETE FROM Token t WHERE t.user.id=:user_id")
})
public class Token implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "key", unique = true, nullable = false)
	private String key;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", unique=true, nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	public User getUser() {
		return user;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public void setUser(User user) {
		this.user = user;
	}
	


	
}
