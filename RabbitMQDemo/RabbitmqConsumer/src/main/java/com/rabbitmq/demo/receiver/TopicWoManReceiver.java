package com.rabbitmq.demo.receiver;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "topic.woman")
public class TopicWoManReceiver {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("TopicWoManReceiver消费者收到消息  : " + testMessage.toString());
    }

}
