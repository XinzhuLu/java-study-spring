package space.xinzhu.base.io;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class BlockingQueueDemo {

    public static AtomicInteger breaCount = new AtomicInteger(0);

    public static ReentrantLock rlock = new ReentrantLock();

    public static class Cooker extends Thread {

        private ArrayBlockingQueue<String> bd;

        public Cooker(ArrayBlockingQueue<String> bd) {
            this.bd = bd;
        }
//    生产者步骤：
//            1，判断桌子上是否有汉堡包
//    如果有就等待，如果没有才生产。
//            2，把汉堡包放在桌子上。
//            3，叫醒等待的消费者开吃。

        @Override
        public void run() {
            while (rlock.isLocked()) {
                rlock.lock();
                try {

                    bd.put("汉堡包");
                    breaCount.getAndIncrement();
                    System.out.println("厨师放入一个汉堡包，数量为：" + breaCount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    rlock.unlock();
                }
            }
        }
    }

    public static class Foodie extends Thread {
        private ArrayBlockingQueue<String> bd;

        public Foodie(ArrayBlockingQueue<String> bd) {
            this.bd = bd;
        }

        @Override
        public void run() {
//        1，判断桌子上是否有汉堡包。
//        2，如果没有就等待。
//        3，如果有就开吃
//        4，吃完之后，桌子上的汉堡包就没有了
//                叫醒等待的生产者继续生产
//        汉堡包的总数量减一

            //套路:
            //1. while(true)死循环
            //2. synchronized 锁,锁对象要唯一
            //3. 判断,共享数据是否结束. 结束
            //4. 判断,共享数据是否结束. 没有结束
            while (rlock.isLocked()) {
                rlock.lock();
                try {
                    String take = bd.take();
                    breaCount.getAndDecrement();
                    System.out.println("吃货将" + take + "拿出来吃了，数量为----" + breaCount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    rlock.unlock();
                }
            }

        }
    }

    public static void main(String[] args) {
        ArrayBlockingQueue<String> bd = new ArrayBlockingQueue<>(1);

        Foodie f = new Foodie(bd);
        Cooker c = new Cooker(bd);

        f.start();
        c.start();
    }


    void method() throws Exception {
        // 创建阻塞队列的对象,容量为 1
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(5);

        // 存储元素
        arrayBlockingQueue.put("汉堡包");

        // 取元素
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take()); // 取不到会阻塞

        System.out.println("程序结束了");
    }
}
