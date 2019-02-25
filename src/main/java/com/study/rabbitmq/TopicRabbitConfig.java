package com.study.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wguo
 * @date 2019/02/20 17:00
 */
@Configuration
public class TopicRabbitConfig {

    final static String message = "topic.A";
    final static String messages = "topic.B";


    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitConfig.messages);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }
}
