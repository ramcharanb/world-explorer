package com.explorer.fetchcountryattractionservice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fetchcountry")
public class FetchCountry {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column( name ="image")
	private String image;
	
	@Column(name ="description")
	private String description;
	
	@Column(name = "userId")
	private String userId;
	
	public FetchCountry(){
		
	}

	public FetchCountry(int id, String name, String currency, String image,
			String description, String userId) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.description = description;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "FetchCountry [id=" + id + ", name=" + name + ", image=" + image + ", description=" + description
				+ ", userId=" + userId + "]";
	}

	
	
}
