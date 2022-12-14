package space.xinzhu.base.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/07
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class ExecutorServiceDemo {

    //static ExecutorService newCachedThreadPool()   创建一个默认的线程池
    //static newFixedThreadPool(int nThreads)	    创建一个指定最多线程数量的线程池

    public static void main(String[] args) throws InterruptedException {

        //1,创建一个默认的线程池对象.池子中默认是空的.默认最多可以容纳int类型的最大值.
        //ExecutorService executorService = Executors.newCachedThreadPool();
        //Executors --- 可以帮助我们创建线程池对象
        //ExecutorService --- 可以帮助我们控制线程池

        //executorService.submit(()->{
        //    System.out.println(Thread.currentThread().getName() + "在执行了");
        //});

        //Thread.sleep(2000);

        //executorService.submit(()->{
        //    System.out.println(Thread.currentThread().getName() + "在执行了");
        //});

        //executorService.shutdown();

        //参数不是初始值而是最大值
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ThreadPoolExecutor pool = (ThreadPoolExecutor) executorService;
        System.out.println(pool.getPoolSize());//0

        executorService.submit(()->{
            System.out.println(Thread.currentThread().getName() + "在执行了");
        });

        executorService.submit(()->{
            System.out.println(Thread.currentThread().getName() + "在执行了");
        });

        System.out.println(pool.getPoolSize());//2
//        executorService.shutdown();
    }

}
