package com.boot.assignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.assignment.entity.User;
import com.boot.assignment.service.UserService;

@RestController
public class UserController {

	
		@Autowired
		private UserService userService;
		
		
		
		
		//All User
		@GetMapping("/users")
		public ResponseEntity<List<User>> getUser() {
			List<User> list=userService.getAllUser();
			if(list.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(list));
		}
		
		
		
		
		
		//single User
		
		@GetMapping("/users/{id}")
		public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
			User user=userService.getUserId(id);
			if(user==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(user));
		}
		
		
		
		
		//Add Book
		
		@PostMapping("/users")
		public ResponseEntity<User> addUser(@RequestBody User user) {
			User user1=null;
			try {
				 user1=	this.userService.addUser(user);
				 return ResponseEntity.status(HttpStatus.CREATED).body(user1);
			}
			catch(Exception e) {
				//To handel Exception
				   e.printStackTrace();
				   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			   }
			
		}
		
		//Delete User
		@DeleteMapping("users/{userid}")
		public ResponseEntity<Void> deleteUser(@PathVariable("userid") int userid) {
			
			try {
				this.userService.deleteUser(userid);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}catch(Exception e) {
				//To handel Exception
				   e.printStackTrace();
				   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			   }
		}
		
		//Update User
		@PutMapping("users/{userid}")
		public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("userid") int userid){
			try {
				this.userService.updateUser(user,userid);
				return ResponseEntity.ok().body(user);
			}catch(Exception e) {
				//To handel Exception
				   e.printStackTrace();
				   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			   }
			
			
		}
}
