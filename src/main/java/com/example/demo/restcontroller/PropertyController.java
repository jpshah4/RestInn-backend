package com.example.demo.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.PropertyService;
import com.example.demo.entity.Property;


@RestController
public class PropertyController {

	@Autowired
	private PropertyService propertyService;
	
	@PostMapping("/Properties")
	public ResponseEntity<Property> addProperty(@RequestBody Property property)
	{
		Property p = propertyService.createProperty(property);
		return new ResponseEntity<Property>(p, HttpStatus.CREATED);
	}
	 
	@GetMapping("/Properties")
	@CrossOrigin
	public ResponseEntity<List<Property>> getAllProperties(@RequestParam(required = false) boolean bestSeller)
	{
		List<Property> p;
		if(bestSeller)
			p = propertyService.getPropertyByBestSeller();
		else
			p = propertyService.getAllProperties();
		
		if(p!=null)
			return new ResponseEntity<List<Property>>(p, HttpStatus.OK);
		return new ResponseEntity<List<Property>>(new ArrayList<Property>(), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/Properties/{propertyId}")
	@CrossOrigin
	public ResponseEntity<Property> getProperty(@PathVariable String propertyId)
	{
		Property p = propertyService.getProperty(propertyId);
		if (p !=null) 
		{
			return new ResponseEntity<Property>(p, HttpStatus.OK); 
			
		} 
		else 
		{
			return new ResponseEntity<Property>(new Property(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/Properties/Search/{propertyType}")
	@CrossOrigin
	public ResponseEntity<List<Property>> getPropertyOnType(@PathVariable String propertyType)
	{
		List<Property> p;
		p = propertyService.getPropertyByType(propertyType);
		if (p !=null) 
		{
			return new ResponseEntity<List<Property>>(p, HttpStatus.OK);
		} 
		return new ResponseEntity<List<Property>>(new ArrayList<Property>(), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/Properties/Search")
	@CrossOrigin
	public ResponseEntity<List<Property>> getPropertyOnSearch(@RequestParam(required = false) String type, @RequestParam(required = false) String title)
	{
		List<Property> p;
		//Both 
		if(type!=null && title!=null) 
		{
			p = propertyService.getPropertyByTypeAndTitle(type, title);
			if (p !=null) 
			{
				return new ResponseEntity<List<Property>>(p, HttpStatus.OK);
			} 
			return new ResponseEntity<List<Property>>(new ArrayList<Property>(), HttpStatus.NOT_FOUND);
		}
		//only title
		else if(title!=null)
		{
			p = propertyService.getPropertyByTitle(title);
			if (p !=null) 
			{
				return new ResponseEntity<List<Property>>(p, HttpStatus.OK);
			} 
			return new ResponseEntity<List<Property>>(new ArrayList<Property>(), HttpStatus.NOT_FOUND);
		}
		//only type
		else if(type!=null)
		{
			p = propertyService.getPropertyByType(type);
			if (p !=null) 
			{
				return new ResponseEntity<List<Property>>(p, HttpStatus.OK);
			} 
			return new ResponseEntity<List<Property>>(new ArrayList<Property>(), HttpStatus.NOT_FOUND);
		}
		else 
			return new ResponseEntity<List<Property>>(new ArrayList<Property>(), HttpStatus.NOT_FOUND);
	}
	
	
	@PutMapping("/Properties/{propertyId}")
	public ResponseEntity<Property> updateProperty(@RequestBody Property property, @PathVariable String propertyId)
	{
		property.setId(propertyId);
	    Property p = propertyService.getProperty(propertyId);
	    Property pro = propertyService.createProperty(property);	
		if (p!=null) 
		{
			return new ResponseEntity<Property>(pro, HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<Property>(pro, HttpStatus.CREATED);
		}
	}
	
	@DeleteMapping("/Properties/{propertyId}")
	public ResponseEntity<String> deleteProduct(@PathVariable String propertyId)
	{	
		Property p = propertyService.getProperty(propertyId);
		
		if (p != null) 
		{	
			propertyService.deleteProperty(propertyId);
			return new ResponseEntity<String>( "Property deleted: "+propertyId, HttpStatus.OK); 	 
		} else 
		{
			return new ResponseEntity<String>( "Property not available to delete: "+propertyId, HttpStatus.NOT_FOUND); 
		}
	}
}
