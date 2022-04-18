package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.entity.Property;

public interface PropertyDao extends MongoRepository<Property, String>{

	Optional<List<Property>> findByType(String type);
	Optional<List<Property>> findByBestSeller(boolean bestSeller);
	Optional<List<Property>> findByTitle(String title);
	Optional<List<Property>> findByTypeAndTitle(String type, String title);
}
