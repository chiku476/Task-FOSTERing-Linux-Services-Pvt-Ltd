package com.boot.assignment.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.assignment.entity.User;

public interface UserRepository extends CrudRepository <User,Integer> {
  
	public User findById(int id);
}
