package com.boot.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.assignment.dao.UserRepository;

import com.boot.assignment.entity.User;

@Component
public class UserService {
	@Autowired
    public UserRepository userRepository;
    
    
    
    //get All User
    public List<User> getAllUser(){
   	 List<User> list=(List<User>)  this.userRepository.findAll();
   	   return list;
      }
      
    
    
    
    //get Single User by  id
    public User getUserId(int id) {
    	User user=null;
 	   try {
 	     user=  this.userRepository.findById(id);
 	   }catch(Exception e) {
 		   e.printStackTrace();
 	   }
 	  return user;
    }
    
    
    
    
    //Adding the User
    public User addUser (User user) {
    	User result=this.userRepository.save(user);
 	   return result;
    }
    
    
    
    //Delete the book
    public void deleteUser(int userid) {
 	   this.userRepository.deleteById(userid);
    }
    
    
    
    //Update Book
    public void updateUser(User user ,int userid) {
 	   user.setId(userid);
 	   this.userRepository.save(user);
    }
}
