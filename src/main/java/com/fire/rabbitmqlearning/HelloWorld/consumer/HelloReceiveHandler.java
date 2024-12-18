package com.fire.rabbitmqlearning.HelloWorld.consumer;

import com.fire.rabbitmqlearning.HelloWorld.config.HelloRabbitmqConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceiveHandler {

    //监听NAME_HELLO队列
    @RabbitListener(queues = {HelloRabbitmqConfig.NAME_HELLO})
    public void receiveHelloQueueMessage(String msg, Message message, Channel channel) {
        System.out.println("消费者收到消息:"+msg);
    }
}
