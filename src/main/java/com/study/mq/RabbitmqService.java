package com.study.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * 消费者
 * @author kevin
 *
 */
public class RabbitmqService implements MessageListener {

	public void onMessage(Message message) {
		 System.out.println("消息消费者 = " + message.toString());
	}

}
