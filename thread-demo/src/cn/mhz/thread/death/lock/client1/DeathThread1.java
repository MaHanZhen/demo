package cn.mhz.thread.death.lock.client1;

public class DeathThread1 implements Runnable{

    private Object o1;
    private Object o2;
    public DeathThread1(Object o1,Object o2) {
        this.o1=o1;
        this.o2=o2;
    }
    @Override
    public void run() {
        synchronized (o1){
            System.out.println("我已经持有锁o1");
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            synchronized (o2){
                System.out.println("我已经持有锁o2");
            }

        }
    }

}
