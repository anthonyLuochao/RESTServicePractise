package com.example.rest.webservices.restfulwebservices;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
	
	//get /users
	//retrieveAllUsers
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
		
	}
	
	//retrieveUser(int id)
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id)
	{
		return service.findOne(id);
	}
	
	//create user
	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		User savedUser=service.save(user);
	}

}
