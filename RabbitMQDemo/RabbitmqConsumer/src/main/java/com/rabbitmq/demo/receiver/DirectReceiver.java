package com.rabbitmq.demo.receiver;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.Map;

@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
public class DirectReceiver {

    private String name;

    public DirectReceiver(String name){
        this.name = name;
    }

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("消费者"+name+"收到消息  : " + testMessage.toString());
    }

}