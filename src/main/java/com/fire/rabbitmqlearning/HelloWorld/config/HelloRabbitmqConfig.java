package com.fire.rabbitmqlearning.HelloWorld.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloRabbitmqConfig {
    //定义消息队列的名字
    public static final String NAME_HELLO = "queue_hello";

    @Bean
    public Queue queueHello() {
        //创建一个队列队列，并指定队列的名字
        return new Queue(NAME_HELLO,true);
    }
}
