package space.xinzhu.base.thread;

import java.util.concurrent.Semaphore;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/07
 * --------------------------------------------
 * 可以控制访问特定资源的线程数量。
 **/
public class SemaphoreDemo {

    public static class MyRunnable implements Runnable {
        //1.获得管理员对象，
        private Semaphore semaphore = new Semaphore(5);
        @Override
        public void run() {
            //2.获得通行证
            try {
                semaphore.acquire();
                //3.开始行驶
                System.out.println("获得了通行证开始行驶");
                Thread.sleep(5000);
                System.out.println("归还通行证");
                //4.归还通行证
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();

        for (int i = 0; i < 100; i++) {
            new Thread(mr).start();
        }
    }
}
