package com.fire.rabbitmqlearning.HelloWorld.producer;

import com.fire.rabbitmqlearning.HelloWorld.config.HelloRabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSenderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/sender/hello/{message}")
    public String senderHello(@PathVariable String message) {
        /**
         * 参数说明
         * exchnage: 交换机，默认交换机指定为“”即可
         * routingKey ：发送消息的路由键，该模式下使用队列名即可
         * message:消息的内容
         */
        rabbitTemplate.convertAndSend("", HelloRabbitmqConfig.NAME_HELLO,message);
        return "success";
    }
}

