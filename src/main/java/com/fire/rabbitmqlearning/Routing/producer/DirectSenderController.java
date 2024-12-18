package com.fire.rabbitmqlearning.Routing.producer;

import com.fire.rabbitmqlearning.Routing.config.RabbitmqConfigDirect;
import com.fire.rabbitmqlearning.WorkQueue.config.WorkRabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectSenderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/sender/direct/{message}")
    public String senderDirect(@PathVariable String message) {
        /**
         * 参数说明
         * exchnage: 交换机，使用自定义的交换机
         * routingKey ：发送消息的路由键，fanout模式指定为“”
         * message:消息的内容
         */
        rabbitTemplate.convertAndSend(RabbitmqConfigDirect.EXCHANGE_DIRECT, "pay",message);
        rabbitTemplate.convertAndSend(RabbitmqConfigDirect.EXCHANGE_DIRECT, "order",message);
        return "success";
    }

}

