package com.fire.rabbitmqlearning.WorkQueue.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 指定拉取数量
 * 这种消费模式有一个问题，当某个消费者消费能力偏弱会导致后续的消息阻塞，我们可以通过 prefetch 来指定消费者每次只能拉取一个消息，这样的话当某个消费者正在忙碌，那么MQ会把消息推送给别的消费者，防止消息在某个消费者身上发生阻塞。
 *
 * spring:
 *   rabbitmq:
 *     listener:
 *       simple:
 *         prefetch: 1
 */
@Configuration
public class WorkRabbitmqConfig {
    //定义消息队列的名字
    public static final String NAME_WORK = "queue_work";

    @Bean
    public Queue queueWork() {
        //创建一个队列队列，并指定队列的名字
        return new Queue(NAME_WORK,true);
    }
}
