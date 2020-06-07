package com.rabbitmq.demo.config;

import com.rabbitmq.demo.receiver.DirectReceiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DirectReceiverConfig {

    @Bean
    public DirectReceiver directReceiverOne(){
        return new DirectReceiver("one");
    }

    @Bean
    public DirectReceiver directReceiverTwo(){
        return new DirectReceiver("two");
    }

}
