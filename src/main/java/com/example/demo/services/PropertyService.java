package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Property;
import com.example.demo.repository.PropertyDao;

@Service
public class PropertyService {

	@Autowired
    PropertyDao propertyDao;

	public List<Property> getAllProperties() 
	{
		return propertyDao.findAll();
	}

	public Property getProperty(String propertyId) 
	{
		Optional<Property> property = propertyDao.findById(propertyId);
		if(property.isPresent())
			return property.get();
		return null;
	}
	
	public List<Property> getPropertyByType(String type) 
	{
		Optional<List<Property>> property = propertyDao.findByType(type);
		if(property.isPresent())
			return property.get();
		return null;
	}
	
	public List<Property> getPropertyByTitle(String title) 
	{
		Optional<List<Property>> property = propertyDao.findByTitle(title);
		if(property.isPresent())
			return property.get();
		return null;
	}
	
	public List<Property> getPropertyByTypeAndTitle(String type, String title) 
	{
		Optional<List<Property>> property = propertyDao.findByTypeAndTitle(type, title);
		if(property.isPresent())
			return property.get();
		return null;
	}	
	
	public List<Property> getPropertyByBestSeller() 
	{
		Optional<List<Property>> property = propertyDao.findByBestSeller(true);
		if(property.isPresent())
			return property.get();
		return null;
	}

	public Property createProperty(Property property) 
	{
		return propertyDao.save(property);
	}

	public void deleteProperty(String propertyId)
	{
		propertyDao.deleteById(propertyId);
	}

	public Property updateProperty(Property property) 
	{
		return propertyDao.save(property);
	}
}
