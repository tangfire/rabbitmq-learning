package com.fire.rabbitmqlearning.Topics.consumer;

import com.fire.rabbitmqlearning.Routing.config.RabbitmqConfigDirect;
import com.fire.rabbitmqlearning.Topics.config.RabbitmqConfigTopics;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicsReceiveHandler {
    @RabbitListener(queues = {RabbitmqConfigTopics.QUEUE_TOPICS_1})
    public void receiveTopics1(String msg, Message message, Channel channel) {
        System.out.println("receiveDirect1消费者1收到消息:"+msg);
    }

    @RabbitListener(queues = {RabbitmqConfigTopics.QUEUE_TOPICS_2})
    public void receiveTopics2(String msg, Message message, Channel channel) {
        System.out.println("receiveDirect2消费者2收到消息:"+msg);
    }

}
