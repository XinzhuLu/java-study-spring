package space.xinzhu.base.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class ReentrantLockDemo implements Runnable{

    private ReentrantLock lock = new ReentrantLock();

    //票的数量
    private int ticket = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            //synchronized (obj){//多个线程必须使用同一把锁.
            lock.lock();
            try {

                if (ticket <= 0) {
                    //卖完了
                    break;
                } else {
                    Thread.sleep(100);
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + ticket + "张票");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            // }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo ticket = new ReentrantLockDemo();

        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
