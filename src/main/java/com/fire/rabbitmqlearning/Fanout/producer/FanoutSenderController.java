package com.fire.rabbitmqlearning.Fanout.producer;

import com.fire.rabbitmqlearning.Fanout.config.RabbitmqConfigFanout;
import com.fire.rabbitmqlearning.HelloWorld.config.HelloRabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FanoutSenderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/sender/fanout/{message}")
    public String senderFanout(@PathVariable String message) {
        /**
         * 参数说明
         * exchnage: 交换机，使用自定义的交换机
         * routingKey ：发送消息的路由键，fanout模式指定为“”
         * message:消息的内容
         */
        rabbitTemplate.convertAndSend(RabbitmqConfigFanout.EXCHANGE_FANOUT, "",message);
        return "success";
    }

}

