package com.mthree.RESTFullWebService.service;

import java.util.List;
import java.util.Optional;

import com.mthree.RESTFullWebService.User;

public interface IService {
	public List<User> findAll();
	User findById(int id);
	public User save(User user);
	public User deleteById(int id);
	List<User> findByName(String name);
//	public User updateById(int id, User user);
	
//	public User updateUser(int id, User user);


}