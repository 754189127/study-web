package com.study.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wguo
 * @date 2019/02/18 17:48
 */
@Component
public class SimpleSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void send() {
        for(int i=0;i<10;i++) {
            String context = i+"发送一条rabbitmq消息!" + sdf.format(new Date());
            System.out.println("SimpleSend 开始发送消息 : " + context);
            this.rabbitTemplate.convertAndSend("simple", context);
        }
    }

}
