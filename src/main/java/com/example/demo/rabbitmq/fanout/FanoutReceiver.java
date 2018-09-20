package com.example.demo.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.A,fanout.B,fanout.C")
public class FanoutReceiver {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiver: " + msg);
    }
}
