package space.xinzhu.base.thread;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/07
 * --------------------------------------------
 * 在集合类中HashMap是比较常用的集合对象，但是HashMap是线程不安全的(多线程环境下可能会存在问题)。为了保证数据的安全性我们可以使用Hashtable，但是Hashtable的效率低下。
 **/
public class HashTableDemo {

    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();

        Hashtable<String, String> hm = new Hashtable<>();
        //HashMap<String, String> hm = new HashMap<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 2500000; i++) {
                hm.put(i + "", i + "");
            }
        });


        Thread t2 = new Thread(() -> {
            for (int i = 2500000; i < 5100000; i++) {
                hm.put(i + "", i + "");
            }
        });

        t1.start();
        t2.start();

        System.out.println("----------------------------");
        //为了t1和t2能把数据全部添加完毕
        Thread.sleep(1000);

        //0-0 1-1 ..... 50- 50

        //for (int i = 0; i < 5100000; i++) {
        //    System.out.println(hm.get(i + ""));
        //}//0 1 2 3 .... 50

        Long end = System.currentTimeMillis();

        System.out.println(start-end);
    }

}
