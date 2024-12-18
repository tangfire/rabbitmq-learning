package com.fire.rabbitmqlearning.Topics.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfigTopics {
    //定义消息队列的名字
    public static final String QUEUE_TOPICS_1 = "topics_queue1";
    public static final String QUEUE_TOPICS_2 = "topics_queue2";
    public static final String EXCHANGE_TOPICS = "exchnage-topics";


    @Bean
    public Exchange exchangeTopics(){
        //定义一个direct类型的交换机，并指定持久化
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPICS).durable(true).build();
    }

    @Bean
    public Queue queueTopics1() {
        //创建一个队列队列，并指定队列的名字
        return new Queue(QUEUE_TOPICS_1,true);
    }

    @Bean
    public Queue queueTopics2() {
        //创建一个队列队列，并指定队列的名字
        return new Queue(QUEUE_TOPICS_2,true);
    }

    @Bean
    public Binding bindingQueueTopics1() {
        return BindingBuilder
                .bind(queueTopics1()).to(exchangeTopics()).with("#.pay").noargs();
    }
    @Bean
    public Binding bindingQueueTopics2() {
        return BindingBuilder
                .bind(queueTopics2()).to(exchangeTopics()).with("#.order").noargs();
    }
}
