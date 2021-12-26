package com.netty.sync.demo.dto;

import java.util.concurrent.CountDownLatch;

public class SyncMessage {

    private String messageId;

    private String req;

    private String resp;

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public String createReqMessage(){
        return messageId+"|"+req+"\r\n";
    }
}
