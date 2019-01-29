package com.study.controller;


import com.study.domain.User;
import com.study.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wguo
 * @date 2019/01/29 13:56
 */
@RestController
public class IndexController {

   @Autowired
    private UserMapper userMapper;

    @RequestMapping("/index")
    public User index(){
       return userMapper.selectByPrimaryKey(1);
    }
}
