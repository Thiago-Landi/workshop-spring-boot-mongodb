package com.thiagolandi.workshopmongo.services;

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
	
}
