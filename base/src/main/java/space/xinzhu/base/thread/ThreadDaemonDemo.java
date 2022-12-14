package space.xinzhu.base.thread;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class ThreadDaemonDemo extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "---" + i);
        }
    }

    public static class MyThread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(getName() + "---" + i);
            }
        }
    }
    public static class MyThread2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(getName() + "---" + i);
            }
        }
    }

    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();

        t1.setName("女神");
        t2.setName("备胎");

        //把第二个线程设置为守护线程
        //当普通线程执行完之后,那么守护线程也没有继续运行下去的必要了.
        t2.setDaemon(true);

        t1.start();
        t2.start();
    }
}
