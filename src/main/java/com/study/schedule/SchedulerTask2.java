package com.study.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wguo
 * @date 2019/02/18 14:23
 */
@Component
public class SchedulerTask2 {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @Scheduled(fixedRate = 6000) 上一次执行时间点之后6秒再执行
     * @Scheduled(fixedDelay=6000)  上一次执行完毕时间点之后6秒再执行
     * @Scheduled(initialDelay = 2000,fixedDelay=6000)  第一次延迟2秒后执行，之后fixedRate 规则每6秒再执行
     */
    @Scheduled(initialDelay = 2000,fixedDelay = 5000)
    public void reportCurrentTime(){
        System.out.println("当前时间:"+sdf.format(new Date()));
    }
}
