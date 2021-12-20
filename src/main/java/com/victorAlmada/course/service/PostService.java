package com.victorAlmada.course.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorAlmada.course.domain.Post;
import com.victorAlmada.course.repository.PostRepository;
import com.victorAlmada.course.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	PostRepository repository;

	public List<Post> findAll() {
		return repository.findAll();
	}

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String text) {
	return repository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text,Date minDate,Date maxDate) {
		maxDate = new Date(maxDate.getTime()+ 24*60*60*1000);
		return repository.fullSearch(text, minDate, maxDate);
	}

}
