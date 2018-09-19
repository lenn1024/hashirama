package com.example.demo.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.queue")
public class TopicReceiver {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("Topic Receiver: " + msg);
    }
}
