

package com.example.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PropertyType;

@Repository
public interface PropertyTypeDao extends MongoRepository<PropertyType, String>
{
}
