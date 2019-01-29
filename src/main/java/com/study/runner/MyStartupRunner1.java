package com.study.runner;

import org.springframework.boot.CommandLineRunner;

/**
 * @author wguo
 * @date 2019/01/29 11:30
 */
public class MyStartupRunner1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行 1111 <<<<<<<<<<<<<");
    }
}
