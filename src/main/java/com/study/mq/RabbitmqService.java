package com.study.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * ������
 * @author kevin
 *
 */
public class RabbitmqService implements MessageListener {

	public void onMessage(Message message) {
		 System.out.println("��Ϣ������ = " + message.toString());
	}

}
