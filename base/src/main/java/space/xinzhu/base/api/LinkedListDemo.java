package space.xinzhu.base.api;

import java.util.LinkedList;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class LinkedListDemo {
    public static void main(String[] args) {
        method4();
    }
    /*
     *  void push(E e)： 压入。把元素添加到集合的第一个位置。
     *  E pop()： 弹出。把第一个元素删除，然后返回这个元素。
     */
    public static void method4() {
        //创建LinkedList对象
        LinkedList<String> list = new LinkedList<>();
        //添加元素
        list.add("达尔文");
        list.add("达芬奇");
        list.add("达尔优");
        System.out.println("list:" + list);
        //调用push在集合的第一个位置添加元素
        //list.push("爱迪生");
        //System.out.println("list:" + list);//[爱迪生, 达尔文, 达芬奇, 达尔优]

        //E pop()： 弹出。把第一个元素删除，然后返回这个元素。
        String value = list.pop();
        System.out.println("value:" + value);//达尔文
        System.out.println("list:" + list);//[达芬奇，达尔优]
    }

    /*
     * E removeFirst()：删除第一个元素
     * E removeLast()：删除最后一个元素。
     */
    public static void method3() {
        //创建LinkedList对象
        LinkedList<String> list = new LinkedList<>();
        //添加元素
        list.add("达尔文");
        list.add("达芬奇");
        list.add("达尔优");
        //删除集合的第一个元素
//		String value = list.removeFirst();
//		System.out.println("value:" + value);//达尔文
//		System.out.println("list:" + list);//[达芬奇，达尔优]

        //删除最后一个元素
        String value = list.removeLast();
        System.out.println("value:" + value);//达尔优
        System.out.println("list:" + list);//[达尔文， 达芬奇]
    }

    /*
     * E getFirst()： 获取集合中的第一个元素
     * E getLast()： 获取集合中的最后一个元素
     */
    public static void method2() {
        //创建LinkedList对象
        LinkedList<String> list = new LinkedList<>();
        //添加元素
        list.add("达尔文");
        list.add("达芬奇");
        list.add("达尔优");

        System.out.println("list:" + list);
        //获取集合中的第一个元素
        System.out.println("第一个元素是：" + list.getFirst());
        //获取集合中的最后一个元素怒
        System.out.println("最后一个元素是：" + list.getLast());
    }


    /*
     * void addFirst(E e)： 在集合的开头位置添加元素。
     * void addLast(E e)： 在集合的尾部添加元素。
     */
    public static void method1() {
        //创建LinkedList对象
        LinkedList<String> list = new LinkedList<>();
        //添加元素
        list.add("达尔文");
        list.add("达芬奇");
        list.add("达尔优");
        //打印这个集合
        System.out.println("list:" + list);//[达尔文, 达芬奇, 达尔优]
        //调用addFirst添加元素
        list.addFirst("曹操");
        System.out.println("list:" + list);//[曹操, 达尔文, 达芬奇, 达尔优]
        //调用addLast方法添加元素
        list.addLast("大乔");
        System.out.println("list:" + list);//[曹操, 达尔文, 达芬奇, 达尔优, 大乔]

    }
}
