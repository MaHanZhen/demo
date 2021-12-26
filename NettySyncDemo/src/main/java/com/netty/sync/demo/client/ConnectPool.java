package com.netty.sync.demo.client;

import com.netty.sync.demo.dto.SyncMessage;
import io.netty.channel.ChannelFuture;

import java.util.Currency;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectPool {

    /**
     * 缓存链接
     */
    private static Map<String, ChannelFuture> CONNECT_POOL = new ConcurrentHashMap<>();

    /**
     * 缓存消息对象
     */
    private static Map<String, SyncMessage> MESSAGE_CACHE = new ConcurrentHashMap<>();


    public static void addConnect(String host,ChannelFuture channelFuture){
        CONNECT_POOL.put(host,channelFuture);
    }

    public static ChannelFuture getConnect(String host){
       return CONNECT_POOL.get(host);
    }

    public static void addMessage(SyncMessage message){
        MESSAGE_CACHE.put(message.getMessageId(),message);
    }

    public static SyncMessage getMessage(String messageId){
        return MESSAGE_CACHE.get(messageId);
    }

    public static SyncMessage removeMessage(String messageId){
        return MESSAGE_CACHE.remove(messageId);
    }

}
