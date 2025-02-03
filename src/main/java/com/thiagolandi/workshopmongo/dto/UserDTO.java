package com.thiagolandi.workshopmongo.dto;

import java.io.Serializable;

import com.thiagolandi.workshopmongo.domain.User;


// objetivo dos dtos é - Customizar os objetos trafegados conforme a necessidade de cada requisição (por exemplo: para alterar
//um produto, você precisa dos dados A, B e C; já para listar os produtos, eu preciso dos dados A, B e a
//categoria de cada produto, etc.).
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	public UserDTO() {
	}
	
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
