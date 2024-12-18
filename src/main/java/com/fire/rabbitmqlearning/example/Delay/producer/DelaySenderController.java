package com.fire.rabbitmqlearning.example.Delay.producer;

import com.fire.rabbitmqlearning.example.Delay.config.MQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DelaySenderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/sender/delay/{message}")
    public String senderHello(@PathVariable String message) {
        /**
         * 参数说明
         * exchnage: 交换机，默认交换机指定为“”即可
         * routingKey ：发送消息的路由键，该模式下使用队列名即可
         * message:消息的内容
         */
        System.out.println("发送消息: "+message+" 开始时间："+System.currentTimeMillis());
        rabbitTemplate.convertAndSend(
                MQConfig.EXCHNAGE_DELAY,
                MQConfig.ROUTINGKEY_QUEUE_ORDER,
                message
        );

        return "success";
    }
}

