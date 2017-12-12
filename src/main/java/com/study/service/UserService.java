package com.study.service;

import java.util.List;

import com.study.entity.User;

public interface UserService {
	
	public User login(String account,String password)throws Exception;

	public User getById(Long userId);
	
	public int getUserCount();

	public List<User> findAll();

	public User insert(User user);
}
