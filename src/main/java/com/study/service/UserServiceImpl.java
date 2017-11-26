package com.study.service;

import static com.study.common.ValidateUtil.$;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.common.SystemException;
import com.study.dao.UserDao;
import com.study.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	public User login(String account, String password) throws Exception {
		account=$("�˺Ų���Ϊ��",account);
		password=$("���벻��Ϊ��", password);
		User user = userDao.getByAccount(account);
		if(null==user){
			throw new SystemException("�˺Ų�����");
		}
		if(!user.getPassword().equals(password)){
			throw new SystemException("���벻��ȷ");
		}
		return user;
	}
	public User getById(Long userId) {
		return userDao.getById(userId);
	}
	public int getUserCount() {
		return userDao.getUserCount();
	}
	public List<User> findAll() {
		return userDao.findAll();
	}

}
