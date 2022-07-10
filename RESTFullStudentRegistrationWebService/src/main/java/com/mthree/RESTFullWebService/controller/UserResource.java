package com.mthree.RESTFullWebService.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.RESTFullWebService.User;
import com.mthree.RESTFullWebService.exceptionhandling.UserNotFoundException;
import com.mthree.RESTFullWebService.service.IService;

//@Controller

@RestController
public class UserResource {// means rest controller?
	@Autowired // injection
	private IService service; // injection 26 27

//	@RequestMapping(method= RequestMethod.GET,value="/users")
//	public @ResponseBody List<User> retrieveAllUsers() {
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		System.out.println("Inside retriveAllUsers of UserResource");
		return service.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable(value = "id") int eid) { // path variable value will match automatically
		System.out.println("Inside retrieveUser of UserResource");
		User user = service.findById(eid);
		System.out.println(user+ " in UserResurce");
		if(user == null) {
			System.out.println("Going to throw UserNotFoundException");
			throw new UserNotFoundException("id-" + eid + " is not found");
		}
		return user;
	}

	@PostMapping(path = "/users", consumes = "application/json") // consumes not needed here
	public User createUser(@RequestBody @Valid User user, BindingResult result, Model model) {
		System.out.println("Inside createUser of UserResource" + user);
		if(result.hasErrors()) {
			return user;
		} else {
			return service.save(user);
		}
	}

	@DeleteMapping(path = "/users/{id}")
	public User removeUser(@PathVariable int id) {
		System.out.println("Inside removeUser of UserResource "+id);
		return service.deleteById(id);
	}
	@GetMapping(path = "/user/{name}")
	public List<User> retrieveUserByName(@PathVariable String name) {
		System.out.println("Inside retrieveUserByName of UserResource");
		return service.findByName(name);
	}
	
//	  @PutMapping(path="/users/{id}", consumes = "application/json") public User
//	  updateUser(@PathVariable int id, @RequestBody String newName) {
//	  System.out.println("Inside updateUser of UserResource"); return
//	  service.updateById(id, newName); }
	 
}

/*
@PutMapping(path="/users/{id}/{name}")
public User updateUser(@PathVariable int id, @PathVariable String name) {
System.out.println("Inside updateById of UserService");
return service.updateById(id, name); }
*/

/*
@PutMapping(path="/users/{id}", consumes = "application/json") public User
updateUser(@PathVariable int id, @RequestBody String newName) {
System.out.println("Inside updateUser of UserResource") ; return
service.updateById(id, newName); }
*/

/*
@PutMapping(path="/users/{id}")
public User updateUser(@RequestBody User user, @PathVariable int id) {
System.out.println("Inside updateUser of UserResource" + user);
System.out.println(user);
return service.updateUser(user, id); }
*/

/*
@PutMapping(path="/users/{id}") public User updateuser(@RequestBody User
user, @PathVariable int id) { System.out.println(user); return
service.updateUser(user, id); }
*/
/*
@PutMapping(path="/users/{id}", consumes = "application/json")
public User updateUser(@RequestBody User user) {
System.out.println("Inside updateUser of UserResource") ;
return service.updateById(user);}
*/