package com.fire.rabbitmqlearning.Routing.consumer;

import com.fire.rabbitmqlearning.Routing.config.RabbitmqConfigDirect;
import com.fire.rabbitmqlearning.WorkQueue.config.WorkRabbitmqConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectReceiveHandler {
    @RabbitListener(queues = {RabbitmqConfigDirect.QUEUE_DIRECT_1})
    public void receiveDirect1(String msg, Message message, Channel channel) {
        System.out.println("receiveDirect1消费者1收到消息:"+msg);
    }

    @RabbitListener(queues = {RabbitmqConfigDirect.QUEUE_DIRECT_2})
    public void receiveDirect2(String msg, Message message, Channel channel) {
        System.out.println("receiveDirect2消费者2收到消息:"+msg);
    }

}
