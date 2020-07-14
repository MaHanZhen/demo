package cn.mhz.thread.communication.tools;

import java.util.concurrent.CyclicBarrier;

/**
 * 首先初始化线程参与者。
 * 调用 await() 将会在所有参与者线程都调用之前等待。
 * 直到所有参与者都调用了 await() 后，所有线程从 await() 返回继续后续逻辑。
 */
public class CyclicBarrierClient {
    
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3) ;

        new Thread(new Runnable() {
            @Override
            public void run() {
               System.out.println("thread run");
                try {
                    cyclicBarrier.await() ;
                } catch (Exception e) {
                    e.printStackTrace();
                }

               System.out.println("thread end do something");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
               System.out.println("thread run");
                try {
                    cyclicBarrier.await() ;
                } catch (Exception e) {
                    e.printStackTrace();
                }

               System.out.println("thread end do something");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
               System.out.println("thread run");
                try {
                    Thread.sleep(5000);
                    cyclicBarrier.await() ;
                } catch (Exception e) {
                    e.printStackTrace();
                }

               System.out.println("thread end do something");
            }
        }).start();

       System.out.println("main thread");
    }
}
