package com.mthree.RESTFullWebService.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mthree.RESTFullWebService.User;
import com.mthree.RESTFullWebService.exceptionhandling.UserNotFoundException;

@Repository(value="usermemoryjparepos") // another meta annotation, annotation on top of annotation
public class UserInMemoryRepository implements IDAO {
	private static List<User> users = null; //user in array list
	private static int userCount = 3;
	
	static {
		users = new ArrayList<User>();
		users.add(new User(1,"Dilraj",new Date()));
		users.add(new User(2,"Bruce",new Date()));
		users.add(new User(3,"Johnny",new Date()));
	}
	
	public UserInMemoryRepository() {
		System.out.println("Inside Default Constructor of UserInMemoryRepository");
	}
	
	@Override
	public List<User> findAll() {
		System.out.println("Inside findAll of UserInMemoryRepository");//To fire "select * from user table"
		return users;
	}

	/*
	 * @Override public Optional<User> findById(int id) {
	 * System.out.println("Inside findById of UserInMemoryRepository");
	 * Optional<User> user = users.stream().filter(u -> u.getId() == id).findAny();
	 * return user; }
	 */
	
	  @Override
	  public Optional<User> findById(int id) {
	  System.out.println("Inside findById of UserInMemoryRepository");
	  User user = users.stream().filter(u -> u.getId() ==
	  id).findAny().orElse(null); if(user==null) { throw new
	  UserNotFoundException("No user"); } else { Optional<User> opt =
	  Optional.of(user); return opt; }
	  }
	 
	@Override
	public User save(User user) {
		System.out.println("Inside save Constructor of UserInMemoryRepository");
		users.add(user);
		return user;
	}
	
	 @Override 
	 public User deleteById(int id) { 
		 System.out.println("Inside deleteById Constructor of UserInMemoryRepository " +id);
		 Iterator<User> userIterator = users.iterator();
		 while(userIterator.hasNext()) {
			User u = userIterator.next();
			if(u.getId() == id) {
				userIterator.remove();
				return u;
			} } return null;  }
		
//	 @Override 
	 public User updateById(int id, String name) {
		 System.out.println("Inside updateById Constructor of UserInMemoryRepository : "+id+" : " +name); 
		 Iterator<User> userIterator = users.iterator();
		 while(userIterator.hasNext()) {
			 User u = userIterator.next();
			 if(u.getId()==id) {
				 System.out.println("name : " +name);
				 u.setName(name);
				 System.out.println("u : " +u);
				 return u;
			 } } return null; }
		 
		/*
		 * @Override public User updateUser(int id, User user) { // TODO Auto-generated
		 * method stub return null; }
		 */

	
//	  @Override 
//	  public User updateById1(int id, String name) { 
		  // TODO Auto-generated method stub 
//		  return null; }
	  
//	  @Override
	  public User updateById(User name) { 
		  // TODO Auto-generated method stub 
		  return null; }

	@Override
	public List<User> findByName(String name) {
		System.out.println("Inside findById of UserInMemoryRepository");
		List<User> userList =  users.stream().filter(u -> u.getName().equals(name)).toList();
		return userList;
	}
}



/*
@Override public User updateById(int id, User user) {
System.out.println("Inside updateById Constructor of UserInMemoryRepository"
); Iterator<User> userIterator = users.iterator();
while(userIterator.hasNext()) { User u = userIterator.next(); if(u.getId() ==
id) { u.setId(user.getId()); u.setName(user.getName());
u.setBirthday(user.getBirthday()); return u; } } return user; }
*/

/*
 @Override public User updateById(User user) { for(int i=0; i < users.size();
 i++) { if(users.get(i).getId() == user.getId()) { users.set(i, user); return
 user; } } return null; }
 */