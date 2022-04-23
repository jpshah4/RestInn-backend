package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PropertyType;
import com.example.demo.repository.PropertyTypeDao;


@Service
public class PropertyTypeService {

	@Autowired
    PropertyTypeDao propertytypeDao;
	
	
	public List<PropertyType> getAllPropertyType() 
	{
		return propertytypeDao.findAll();
	}
	
	public PropertyType createPropertyType(PropertyType propertytype) 
	{
		return propertytypeDao.save(propertytype);
	}
}
