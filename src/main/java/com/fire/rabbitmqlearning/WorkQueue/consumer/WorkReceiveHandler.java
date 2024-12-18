package com.fire.rabbitmqlearning.WorkQueue.consumer;

import com.fire.rabbitmqlearning.WorkQueue.config.WorkRabbitmqConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkReceiveHandler {

    //监听NAME_HELLO队列
    @RabbitListener(queues = {WorkRabbitmqConfig.NAME_WORK})
    public void receive1(String msg, Message message, Channel channel) {
        System.out.println("消费者1收到消息:"+msg);
    }

    //监听NAME_HELLO队列
    @RabbitListener(queues = {WorkRabbitmqConfig.NAME_WORK})
    public void receive2(String msg, Message message, Channel channel) {
        System.out.println("消费者2收到消息:"+msg);
    }
}
