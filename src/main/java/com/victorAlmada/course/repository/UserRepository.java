package com.victorAlmada.course.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.victorAlmada.course.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	public Optional<User> findByEmail(String email);
		
	
}
