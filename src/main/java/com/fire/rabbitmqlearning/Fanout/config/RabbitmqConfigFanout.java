package com.fire.rabbitmqlearning.Fanout.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfigFanout {
    //定义消息队列的名字
    public static final String QUEUE_1 = "queue1";
    public static final String QUEUE_2 = "queue2";
    public static final String EXCHANGE_FANOUT = "exchnage-fanout";


    @Bean
    public Exchange exchange(){
        //定义一个fanout类型的交换机，并指定持久化
        return ExchangeBuilder.fanoutExchange(EXCHANGE_FANOUT).durable(true).build();
    }

    @Bean
    public Queue queue1() {
        //创建一个队列队列，并指定队列的名字和持久化
        return new Queue(QUEUE_1,true);
    }

    @Bean
    public Queue queue2() {
        //创建一个队列队列，并指定队列的名字
        return new Queue(QUEUE_2,true);
    }

    @Bean
    public Binding bindingQueue1() {
        //fanout模式不指定routingkey
        return BindingBuilder
                .bind(queue1()).to(exchange()).with("").noargs();
    }
    @Bean
    public Binding bindingQueue2() {
        return BindingBuilder
                .bind(queue2()).to(exchange()).with("").noargs();
    }
}
