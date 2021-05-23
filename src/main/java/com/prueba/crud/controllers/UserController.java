package com.prueba.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.crud.models.UserDTO;
import com.prueba.crud.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@PostMapping("/user")
	public UserDTO create(@Validated @RequestBody UserDTO u) {
		return repository.insert(u);
	}
	
	@GetMapping("/")
	public List<UserDTO> readList() {
		return repository.findAll();
	}
	
	@PutMapping("/user/{id}")
	public UserDTO update(@PathVariable String id, @Validated @RequestBody UserDTO u) {
		return repository.save(u);
	}
	
	@DeleteMapping("/user/{id}")
	public void delete (@PathVariable String id) {
		repository.deleteById(id);
	}
}
