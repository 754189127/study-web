package com.study.dao;

import java.util.List;

import com.study.entity.User;

public interface UserDao {
	public User getByAccount(String account)throws Exception;

	public User getById(Long userId);

	public int getUserCount();

	public List<User> findAll();
}
