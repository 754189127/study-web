package com.study.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.study.entity.User;
import com.study.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger logger=LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;
	@RequestMapping(value = "/userinfo/{id}", method = RequestMethod.GET)
	public ModelAndView showUserInfo(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("info");
		User user = userService.getById(id);
		if (user != null) {
			mav.addObject("name", user.getRealName());
		} else {
			mav.addObject("name", "鏌ユ棤姝ょ敤鎴�");
		}
		logger.debug("============userinfo debug");
		logger.info("=======userinfo info");
		logger.error("===========userinfo error");
		return mav;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showHome() {
		ModelAndView mav = new ModelAndView("home");
		int count = userService.getUserCount();
		mav.addObject("count", count);
		
		return mav;
	}

	@RequestMapping("/list")
	public ModelAndView listall() {
		List<User> users = userService.findAll();
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("users", users);
		logger.debug("============list debug");
		logger.info("=======list info");
		logger.error("===========list error");
		return mav;
	}
	
	public static void main(String[] args) {
		
		//当前cpu核心个数
		int a = Runtime.getRuntime().availableProcessors();
		System.out.println(a);
	}
}
