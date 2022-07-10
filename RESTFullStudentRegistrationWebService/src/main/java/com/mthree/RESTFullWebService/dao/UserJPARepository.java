package com.mthree.RESTFullWebService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.RESTFullWebService.User;

@Repository(value = "userjparepos")
public interface UserJPARepository extends IDAO, JpaRepository<User, Integer> {
	/*
	 findById  : Retrieves one object based on the ID you pass it
	 findAll   : Retrieves a list of all the objects of the type
	 save  	   : Used for both creating and updating an object; returns the object that was created or updated as it now exists in the database
	 deleteById: Deletes the object with the passed ID from the database
	 count     : Retrieves a count of all objects of a type in the database
	 existsById: Checks if an object with the passed ID exists in the database; returns true or false
	 */
	public List<User> findByName(String name);
}
