package com.fire.rabbitmqlearning.example.Delay.consumer;

import com.fire.rabbitmqlearning.example.Delay.config.MQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = MQConfig.QUEUE_DELAY)
    public void handler(String message){
        System.out.println("收到消息："+message+",结束时间："+System.currentTimeMillis());
    }
}
