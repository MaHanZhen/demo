package com.mhz.rabbit.demo;

import com.mhz.rabbit.demo.config.DirectRabbitConfig;
import com.mhz.rabbit.demo.config.FanoutRabbitConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void sendDirectMessage(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        for (int i = 0; i < 10; i++) {
            map.put("index",i);
            rabbitTemplate.convertAndSend(DirectRabbitConfig.EXCHANGE_NAME, DirectRabbitConfig.ROUTING_NAME, map);
        }

    }


    @Test
    void sendFanoutMessage(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);

        rabbitTemplate.convertAndSend(FanoutRabbitConfig.EXCHANGE_NAME, null,map);

    }

    @Test
    public void sendTopicMessage(){
        sendTopicMessageMan();
        sendTopicMessageWoman();
    }

    public void sendTopicMessageMan() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: M A N ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        manMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", manMap);
    }


    public void sendTopicMessageWoman() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: woman is all ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> womanMap = new HashMap<>();
        womanMap.put("messageId", messageId);
        womanMap.put("messageData", messageData);
        womanMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.woman", womanMap);
    }

}
