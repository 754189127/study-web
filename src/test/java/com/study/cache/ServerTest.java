package com.study.cache;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.entity.User;
import com.study.service.UserService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class ServerTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testFind(){
		System.out.println("testA==========");
		Long userId=2L;
		User user=userService.getById(userId);
		System.out.println("============user:"+user);
		Assert.assertTrue(user!=null);
	}
	
	@Test
	public void testAdd(){
		System.out.println("======testAdd");
		User user=new User();
		user.setAccount("003");
		user.setRealName("ÐÕÃû3");
		user.setPassword("123456");
		user.setCreateTime(new Date());
		User addResult = userService.insert(user);
		System.out.println("=====addResult:"+addResult);
	}
}
