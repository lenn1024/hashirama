package com.example.demo.rabbitmq.fanout;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {
    @Bean
    public Queue fanoutQueueA(){
        return new Queue("fanout.A");
    }

    @Bean
    public Queue fanoutQueueB(){
        return new Queue("fanout.B");
    }

    @Bean
    public Queue fanoutQueueC(){
        return new Queue("fanout.C");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout.exchange");
    }

    @Bean
    public Binding bingA2FanoutExchange(Queue fanoutQueueA, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueueA).to(fanoutExchange);
    }

    @Bean
    public Binding bingB2FanoutExchange(Queue fanoutQueueB, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueueB).to(fanoutExchange);
    }

    @Bean
    public Binding bingC2FanoutExchange(Queue fanoutQueueC, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueueC).to(fanoutExchange);
    }

}
