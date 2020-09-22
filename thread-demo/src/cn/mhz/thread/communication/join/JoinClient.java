package cn.mhz.thread.communication.join;

public class JoinClient {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis()+":running");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }) ;
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis()+":running2");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }) ;

        t1.start();
        t2.start();

//        在 t1.join() 时会一直阻塞到 t1 执行完毕，所以最终主线程会等待 t1 和 t2 线程执行完毕。

        //等待线程1终止
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //等待线程2终止
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main over");
    }
}
