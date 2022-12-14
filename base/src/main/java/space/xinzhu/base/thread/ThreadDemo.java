package space.xinzhu.base.thread;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Thread已经实现Runnable接口
 **/
public class ThreadDemo extends Thread implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    public static void main(String[] args) {
        //创建MyRunnable类的对象
        ThreadDemo my = new ThreadDemo();

        //创建Thread类的对象，把MyRunnable对象作为构造方法的参数
        //Thread(Runnable target)
//        Thread t1 = new Thread(my);
//        Thread t2 = new Thread(my);
        //Thread(Runnable target, String name)
        Thread t1 = new Thread(my,"坦克");
        Thread t2 = new Thread(my,"飞机");

        //启动线程
        t1.start();
        t2.start();
    }
}
