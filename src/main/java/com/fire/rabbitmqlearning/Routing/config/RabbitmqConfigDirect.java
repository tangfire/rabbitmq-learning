package com.fire.rabbitmqlearning.Routing.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfigDirect {
    //定义消息队列的名字
    public static final String QUEUE_DIRECT_1 = "direct_queue1";
    public static final String QUEUE_DIRECT_2 = "direct_queue2";
    public static final String EXCHANGE_DIRECT = "exchnage-direct";


    @Bean
    public Exchange exchangeDirect(){
        //定义一个direct类型的交换机，并指定持久化
        return ExchangeBuilder.directExchange(EXCHANGE_DIRECT).durable(true).build();
    }

    @Bean
    public Queue queueDirect1() {
        //创建一个队列队列，并指定队列的名字
        return new Queue(QUEUE_DIRECT_1,true);
    }

    @Bean
    public Queue queueDirect2() {
        //创建一个队列队列，并指定队列的名字
        return new Queue(QUEUE_DIRECT_2,true);
    }

    @Bean
    public Binding bindingQueueDirect1() {
        return BindingBuilder
                .bind(queueDirect1()).to(exchangeDirect()).with("pay").noargs();
    }
    @Bean
    public Binding bindingQueueDirect2() {
        return BindingBuilder
                .bind(queueDirect2()).to(exchangeDirect()).with("order").noargs();
    }
}
