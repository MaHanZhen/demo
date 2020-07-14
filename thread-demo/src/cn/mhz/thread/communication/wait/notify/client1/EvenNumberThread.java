package cn.mhz.thread.communication.wait.notify.client1;

public class EvenNumberThread implements Runnable {
    WaitNotifyClient client;
    public EvenNumberThread(WaitNotifyClient client) {
        this.client = client;
    }

    @Override
    public void run() {
        while (client.start <= 100) {
            synchronized (WaitNotifyClient.class) {
                System.out.println("偶数线程抢到锁了");

                if (client.flag) {
                    System.out.println(Thread.currentThread().getName() + "+-+偶数" + client.start);
                    client.start++;

                    client.flag = false;
                    WaitNotifyClient.class.notify();

                }else {

                    try {
                        WaitNotifyClient.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
    }
}
