package com.example.netty.demo.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.stereotype.Component;

@Component
public class NettyClientHandler extends ChannelInboundHandlerAdapter {


    private ChannelHandlerContext ctx;
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端Active .....");
        this.ctx = ctx;

        ctx.writeAndFlush("QIU");
//        while (true){
//            Scanner scanner =new Scanner(System.in);
//            String str = scanner.nextLine();
//            System.out.print("输入字符串");
//            sendCommand(str);
//        }

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("客户端收到消息: "+msg.toString());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    public void sendCommand(String str){
        ctx.writeAndFlush(str);
    }
}
