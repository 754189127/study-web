package com.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wguo
 * @date 2019/01/29 11:10
 */
@RestController
@RequestMapping("/")
public class HellloController {

    @RequestMapping("/hello")
    public String index(){
        return "hello!";
    }
}
