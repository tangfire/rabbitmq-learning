package com.fire.rabbitmqlearning.Fanout.consumer;

import com.fire.rabbitmqlearning.Fanout.config.RabbitmqConfigFanout;
import com.fire.rabbitmqlearning.HelloWorld.config.HelloRabbitmqConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiveHandler {

    @RabbitListener(queues = {RabbitmqConfigFanout.QUEUE_1})
    public void receiveFanout1(String msg, Message message, Channel channel) {
        System.out.println("fanout消费者1收到消息:"+msg);
    }

    @RabbitListener(queues = {RabbitmqConfigFanout.QUEUE_2})
    public void receiveFanout2(String msg, Message message, Channel channel) {
        System.out.println("fanout消费者2收到消息:"+msg);
    }

}
