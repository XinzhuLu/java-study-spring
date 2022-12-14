package space.xinzhu.base.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class ThreadPriorityDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
        return "线程执行完毕了";
    }

    public static void main(String[] args) {
        //优先级: 1 - 10 默认值:5
        ThreadPriorityDemo mc = new ThreadPriorityDemo();

        FutureTask<String> ft = new FutureTask<>(mc);

        Thread t1 = new Thread(ft);
        t1.setName("飞机");
        t1.setPriority(1);
        //System.out.println(t1.getPriority());//5
        t1.start();

        ThreadPriorityDemo mc2 = new ThreadPriorityDemo();

        FutureTask<String> ft2 = new FutureTask<>(mc2);

        Thread t2 = new Thread(ft2);
        t2.setName("坦克");
        t2.setPriority(10);
        //System.out.println(t2.getPriority());//5
        t2.start();
    }
}
