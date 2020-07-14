package cn.mhz.thread.death.lock.client1;

public class DeathLockClient {


    public static void main(String[] args) {

        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(new DeathThread1(lock1,lock2));
        Thread thread2 = new Thread(new DeathThread2(lock1,lock2));

        thread1.start();
        thread2.start();

    }
}
