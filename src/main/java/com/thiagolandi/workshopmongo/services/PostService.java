package com.thiagolandi.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagolandi.workshopmongo.domain.Post;
import com.thiagolandi.workshopmongo.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.get();
	}
	
	public List<Post> finByTitle(String text){
		return repository.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + (24 * 60 * 60 * 1000) - 1);
		return repository.fullSearch(text, minDate, maxDate);
	}
}
