package com.restful.user;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restful.api.test.HelloWorldRestApp.DeployableWarApplication;

@RestController
public class UserResource {
	
	static {
		final java.util.logging.Logger log = java.util.logging.Logger.getLogger(DeployableWarApplication.class.getName());

	}
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping(path = "/userslist")
	public List<User> retriveallUsers() {
	
		System.out.println("retriveAllUser resource called..");
		return service.findAll();
	
		
	}

	// get specific users user list
	/*@GetMapping("/users/{id}")
	public Resource<User> retriveUser(@PathVariable int id) {
		User user = service.findOne(id);

		if (user == null)
			throw new UserNotFoundExecption("id-" + id);
		
		// HATEOAS
		//"all-users",SERVER_PATH + "/user"
		//retriveAllUsers
		Resource<User> resource= new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass(),retriveallUsers()));
		
		resource.add(linkTo.withRel("all-users"));
		System.out.println("retriveUser resource called....");
		return resource;
	}
*/
	//find user by Id
	@GetMapping("/users{id}")
	public User retriveUserById(@PathVariable int id) {
		
		User user=service.findOne(id);
		if(user==null)
			throw new UserNotFoundExecption("id:-"+id);
		return user;
	}
	
	//delete user resources
	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);

		if (user == null)
			throw new UserNotFoundExecption("id-" + id);
		return user;
	}

	// create a user
	// input details of users
	// output - Created & Return the created URI
	@PostMapping("/users")
	public ResponseEntity<Object> creatUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		// Created
		// /users/{id} savedUser.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

}
