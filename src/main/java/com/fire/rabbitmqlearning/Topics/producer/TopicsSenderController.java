package com.fire.rabbitmqlearning.Topics.producer;

import com.fire.rabbitmqlearning.Routing.config.RabbitmqConfigDirect;
import com.fire.rabbitmqlearning.Topics.config.RabbitmqConfigTopics;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicsSenderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/sender/topics/{message}")
    public String senderDirect(@PathVariable String message) {
        /**
         * 参数说明
         * exchnage: 交换机，使用自定义的交换机
         * routingKey ：发送消息的路由键，fanout模式指定为“”
         * message:消息的内容
         */
        rabbitTemplate.convertAndSend(RabbitmqConfigTopics.EXCHANGE_TOPICS, "good.pay",message);
        rabbitTemplate.convertAndSend(RabbitmqConfigTopics.EXCHANGE_TOPICS, "account.pay",message);
        rabbitTemplate.convertAndSend(RabbitmqConfigTopics.EXCHANGE_TOPICS, "good.order",message);

        return "success";
    }

}

