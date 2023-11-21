package com.explorer.userservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class User {
	
	@Id
	private String userId;
	
	private String password;
	
	@CreationTimestamp
	private Date created;

	public User(String userId, String password, Date created) {
		super();
		this.userId = userId;
		this.password = password;
		this.created = created;
	}
	
	public User(){
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password="
				+ password + ", created=" + created + "]";
	}	
	

}
