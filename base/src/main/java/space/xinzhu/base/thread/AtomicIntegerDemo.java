package space.xinzhu.base.thread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/07
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class AtomicIntegerDemo {

    //AtomicBoolean： 原子更新布尔类型
    //AtomicInteger：   原子更新整型
    //AtomicLong：	原子更新长整型
    //
    //public AtomicInteger()：
    //初始化一个默认值为0的原子型Integer
    //public AtomicInteger(int initialValue)：
    //初始化一个指定值的原子型Integer
    //
    //int get():
    //获取值
    //int getAndIncrement():
    //以原子方式将当前值加1，注意，这里返回的是自增前的值。
    //int incrementAndGet():
    //以原子方式将当前值加1，注意，这里返回的是自增后的值。
    //int addAndGet(int data):
    //以原子方式将输入的数值与实例中的值（AtomicInteger里的value）相加，并返回结果。
    //int getAndSet(int value):
    //以原子方式设置为newValue的值，并返回旧值。

    public static void main(String[] args) {
        AtomicInteger ac1 = new AtomicInteger(10);
        System.out.println(ac1.get());

        AtomicInteger ac2 = new AtomicInteger(10);
        int andIncrement = ac2.getAndIncrement();
        System.out.println(andIncrement);
        System.out.println(ac2.get());

        AtomicInteger ac3 = new AtomicInteger(10);
        int i = ac3.incrementAndGet();
        System.out.println(i);//自增后的值
        System.out.println(ac3.get());

        AtomicInteger ac4 = new AtomicInteger(10);
        int i2 = ac4.addAndGet(20);
        System.out.println(i2);
        System.out.println(ac4.get());

        AtomicInteger ac5 = new AtomicInteger(100);
        int andSet = ac5.getAndSet(20);
        System.out.println(andSet);
        System.out.println(ac5.get());
    }

}
