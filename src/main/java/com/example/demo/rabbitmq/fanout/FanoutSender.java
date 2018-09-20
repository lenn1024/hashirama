package com.example.demo.rabbitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        // fanout exchange routingkey 写什么都会被忽略
        amqpTemplate.convertAndSend("fanout.exchange", "", "fanout message.");
    }
}
