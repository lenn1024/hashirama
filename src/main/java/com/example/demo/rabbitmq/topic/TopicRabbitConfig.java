package com.example.demo.rabbitmq.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {
    @Bean
    public Queue topicQueue(){
        return new Queue("topic.queue");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topic.exchange");
    }

    @Bean
    public Binding bindingExchangeQueue(Queue topicQueue, TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueue).to(topicExchange).with("topic.#");
    }
}
