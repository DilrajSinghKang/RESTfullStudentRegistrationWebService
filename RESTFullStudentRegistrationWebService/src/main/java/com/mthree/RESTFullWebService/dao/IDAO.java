package com.mthree.RESTFullWebService.dao;

import java.util.List;
import java.util.Optional;

import com.mthree.RESTFullWebService.User;

public interface IDAO {

	public List<User> findAll();
	Optional<User>findById(int id);
	public User save(User user);
	public User deleteById(int id);
	public List<User> findByName(String name);
//	public User updateUser(int id, User user);

}
