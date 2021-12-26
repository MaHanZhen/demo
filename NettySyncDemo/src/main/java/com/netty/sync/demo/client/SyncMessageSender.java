package com.netty.sync.demo.client;

import com.netty.sync.demo.dto.SyncMessage;
import io.netty.channel.ChannelFuture;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class SyncMessageSender {

    public static String sendMessage(String host,String message){
        ChannelFuture connect = ConnectPool.getConnect(host);
        if(connect == null){
            throw new RuntimeException("为链接");
        }
        String messageId = UUID.randomUUID().toString();
        SyncMessage syncMessage = new SyncMessage();
        syncMessage.setMessageId(messageId);
        syncMessage.setReq(message);
        String messageReq = syncMessage.createReqMessage();
        //添加缓存
        ConnectPool.addMessage(syncMessage);
        connect.channel().writeAndFlush(messageReq);

        try {
            //这里一定要加上超时时间，不然会发生线程无法释放的情况
            syncMessage.getCountDownLatch().await(10, TimeUnit.SECONDS);
            return syncMessage.getResp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //根据情况清理加入的缓存，建议加入缓存和删除缓存在同一个方法体内
            //如果不清理，会引起OOM
            ConnectPool.removeMessage(messageId);
        }
        return null;

    }
}
