package com.study.mq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class TestQueue {
	@Autowired
	private Producer producer;
	@Value("#{appConfig['mq.queue']}")
	private String queueId;
	    
	/**
	 * @Description: ��Ϣ����
	 * @Author: 
	 * @CreateTime: 
	 */
	@ResponseBody
	@RequestMapping("/sendQueue")
	public String testQueue() {
	    try {
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("data", "hello rabbitmq");
	        // ע�⣺�ڶ��������� Queue �� �������󶨵�·��
	        producer.sendQueue(queueId + "_exchange", queueId + "_patt", map);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "�������";
	}
}
