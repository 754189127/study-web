package com.study.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ��Ϣ���з�����
 * @author kevin
 *
 */
@Service
public class Producer {
	 @Autowired
	    private AmqpTemplate amqpTemplate;
	    
	    public void sendQueue(String exchange_key, String queue_key, Object object) {
	        // convertAndSend ��Java����ת��Ϊ��Ϣ������ƥ��key�Ľ�������Exchange
	        amqpTemplate.convertAndSend(exchange_key, queue_key, object);
	    }
}
