package com.example.demo.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PropertyType;
import com.example.demo.services.PropertyTypeService;

@RestController
public class PropertyTypeController {

	@Autowired
	private PropertyTypeService propertytypeService;
	
	@PostMapping("/PropertyType")
	public ResponseEntity<PropertyType> addProperty(@RequestBody PropertyType propertytype)
	{
		PropertyType p = propertytypeService.createPropertyType(propertytype);
		return new ResponseEntity<PropertyType>(p, HttpStatus.CREATED);
	}
	
	@GetMapping("/PropertyType")
	@CrossOrigin
	public ResponseEntity<List<PropertyType>> getAllPropertyType()
	{
		List<PropertyType> p;
		
			p = propertytypeService.getAllPropertyType();
		
		if(p!=null)
			return new ResponseEntity<List<PropertyType>>(p, HttpStatus.OK);
		return new ResponseEntity<List<PropertyType>>(new ArrayList<PropertyType>(), HttpStatus.NOT_FOUND);
	}
}
