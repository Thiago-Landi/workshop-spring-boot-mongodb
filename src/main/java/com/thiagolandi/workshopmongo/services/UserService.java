package com.thiagolandi.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagolandi.workshopmongo.domain.User;
import com.thiagolandi.workshopmongo.repositoy.UserRepository;
import com.thiagolandi.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));// vai lançar o obj e caso esteja vazia, vai lançar uma excessão
	}
}

