package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("PropertyType")
public class PropertyType {
	
	@Id
	private String id;
	private String description;
	private String imageSrc;
	
	
	//constructors
	
	public PropertyType(String id, String description, String imageSrc) {
		super();
		this.id = id;
		this.description = description;
		this.imageSrc = imageSrc;
	}
	
	

	public PropertyType() {
		super();
		// TODO Auto-generated constructor stub
	}


	//setters and getters

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getimageSrc() {
		return imageSrc;
	}



	public void setimageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}



	
	
}
