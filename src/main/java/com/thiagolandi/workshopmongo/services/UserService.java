package com.thiagolandi.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagolandi.workshopmongo.domain.User;
import com.thiagolandi.workshopmongo.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		User user = new User(objDto.getId(), objDto.getName(), objDto.getEmail());
		return user;
	}
}

