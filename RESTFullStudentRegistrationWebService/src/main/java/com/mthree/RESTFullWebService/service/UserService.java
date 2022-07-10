package com.mthree.RESTFullWebService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mthree.RESTFullWebService.User;
import com.mthree.RESTFullWebService.dao.IDAO;
import com.mthree.RESTFullWebService.dao.UserJPARepository;

@Service
public class UserService implements IService {
	
	@Autowired 			// Injected in service
	@Qualifier(value = "userjparepos")
	public IDAO dao; // IDAO to inject user in memory here
	//	public UserJPARepository dao;
	
	public UserService() {
		System.out.println("Inside Default Constructor of UserService");
	}
	
	@Override
	public List<User> findAll() {
		System.out.println("Inside findAll of UserService");
		return dao.findAll();
	}

	@Override
	public User findById(int id) {
		System.out.println("Inside findById of UserService");
		Optional<User> opt = dao.findById(id);
		System.out.println(opt.get() + "inside UserService");
		if(opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	@Override
	public User save(User user) {
		System.out.println("Inside save of UserService");
		return dao.save(user);
	}
	
	@Override 
	public User deleteById(int id) {
		System.out.println("Inside deleteById of UserService " +id); return
				dao.deleteById(id); 
	}
	
	public List<User> findByName(String name) {
		System.out.println("Inside findByName of UserService");
		return dao.findByName(name);
	}
	
//	@Override 
//	public User updateById(User user) {
//		System.out.println("Inside updateUser of UserService"); 
//		return dao.updateById(user); }

}



//@Override
//public User updateById(int id, String name) {
//	System.out.println("Inside updateById of UserService"); 
//	return dao.updateById(id, name); }


	
/*
 * @Override public User updateUser(User user, int id) {
 * System.out.println("Inside updateUser of UserService"); return
 * dao.updateUser(id, user); }
 * 
 * @Override public User updateById(int id, String name) { // TODO
 * Auto-generated method stub return null; }
 */
