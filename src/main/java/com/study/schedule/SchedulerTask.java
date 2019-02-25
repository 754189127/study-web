package com.study.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author wguo
 * @date 2019/02/18 9:42
 */
@Component
public class SchedulerTask {

    private int count = 0;
    @Scheduled(cron = "0/5 * * ? * *")
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
    }
}
