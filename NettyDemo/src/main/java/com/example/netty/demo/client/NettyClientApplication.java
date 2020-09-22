package com.example.netty.demo.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.Scanner;

@SpringBootApplication
public class NettyClientApplication implements CommandLineRunner {

    @Resource
    NettyClientInitializer nettyClientInitializer;

    @Resource
    private NettyClientHandler nettyClientHandler;

    public static void main(String[] args) {
        SpringApplication.run(NettyClientApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap()
                .group(group)
                //该参数的作用就是禁止使用Nagle算法，使用于小数据即时传输
                .option(ChannelOption.TCP_NODELAY, true)
                .channel(NioSocketChannel.class)
                .handler(nettyClientInitializer);

        try {
            ChannelFuture future = bootstrap.connect("127.0.0.1", 8090).sync();
            System.out.println("客户端成功....");

            new Thread(()->{
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("输入字符串:");
                    String str = scanner.nextLine();
                    nettyClientHandler.sendCommand(str);
                }
            }).start();
            // 等待连接被关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }
}
