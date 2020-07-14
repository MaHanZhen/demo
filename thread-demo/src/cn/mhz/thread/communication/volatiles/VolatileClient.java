package cn.mhz.thread.communication.volatiles;

import java.util.concurrent.TimeUnit;

public class VolatileClient implements Runnable{

    private static volatile boolean flag = true ;

    @Override
    public void run() {
        while (flag){
            System.out.println(Thread.currentThread().getName() + "正在运行。。。");
        }
        System.out.println(Thread.currentThread().getName() +"执行完毕");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileClient aVolatile = new VolatileClient();
        new Thread(aVolatile,"thread A").start();

        System.out.println("main 线程正在运行") ;

        TimeUnit.MILLISECONDS.sleep(100) ;

        flag = false;

    }


}
