package space.xinzhu.base.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/07
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class ThreadPoolExecutorDemo {
    //    参数一：核心线程数量
//    参数二：最大线程数
//    参数三：空闲线程最大存活时间
//    参数四：时间单位
//    参数五：任务队列
//    参数六：创建线程工厂
//    参数七：任务的拒绝策略
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                5,
                2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        //决绝策略：
        //ThreadPoolExecutor.AbortPolicy:
        // 丢弃任务并抛出RejectedExecutionException异常。是默认的策略。
        //ThreadPoolExecutor.DiscardPolicy：
        // 丢弃任务，但是不抛出异常 这是不推荐的做法。
        //ThreadPoolExecutor.DiscardOldestPolicy：
        // 抛弃队列中等待最久的任务 然后把当前任务加入队列中。
        //ThreadPoolExecutor.CallerRunsPolicy:
        // 调用任务的run()方法绕过线程池直接执行。


        //pool.submit(new MyRunnable());
        //pool.submit(new MyRunnable());

        pool.shutdown();
    }
}
