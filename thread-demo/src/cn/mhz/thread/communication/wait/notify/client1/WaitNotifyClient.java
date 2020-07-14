package cn.mhz.thread.communication.wait.notify.client1;

public class WaitNotifyClient {


    int start = 1;

    boolean flag = false;

    public static void main(String[] args) {
        WaitNotifyClient client = new WaitNotifyClient();

        Thread t1 = new Thread(new OddNumberThread(client));
        t1.setName("odd number");


        Thread t2 = new Thread(new EvenNumberThread(client));
        t2.setName("even number");

        t1.start();
        t2.start();
    }
}
