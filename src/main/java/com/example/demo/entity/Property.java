package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Property")
public class Property {
	
	@Id
	private String id;
	private String imgLocation;
	private String title;
	private String description;
	private double price;
	private String type;
	private String houseRules;
	private String amenities;
	private String location;
	private boolean bestSeller;
	
	
	//constructors
	
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Property(String id, String imgLocation, String title, String description, double price, String type,
			String houseRules, String amenities, String location, boolean bestSeller) {
		super();
		this.id = id;
		this.imgLocation = imgLocation;
		this.title = title;
		this.description = description;
		this.price = price;
		this.type = type;
		this.houseRules = houseRules;
		this.amenities = amenities;
		this.location = location;
		this.bestSeller = bestSeller;
	}
	

	//setters and getters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImgLocation() {
		return imgLocation;
	}

	public void setImgLocation(String imgLocation) {
		this.imgLocation = imgLocation;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHouseRules() {
		return houseRules;
	}

	public void setHouseRules(String houseRules) {
		this.houseRules = houseRules;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isBestSeller() {
		return bestSeller;
	}

	public void setBestSeller(boolean bestSeller) {
		this.bestSeller = bestSeller;
	}

}
