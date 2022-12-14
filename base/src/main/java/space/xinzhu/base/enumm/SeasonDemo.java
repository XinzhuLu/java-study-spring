package space.xinzhu.base.enumm;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/10
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class SeasonDemo {
    public static void main(String[] args) {
        /*
        1.所有枚举类都是Enum的子类
        2.我们可以通过"枚举类名.枚举项名称"去访问指定的枚举项
        3.每一个枚举项其实就是该枚举的一个对象
        4.枚举也是一个类，也可以去定义成员变量
        5.枚举类的第一行上必须是枚举项，最后一个枚举项后的分号是可以省略的，
          但是如果枚举类有其他的东西，这个分号就不能省略。建议不要省略
        6.枚举类可以有构造器，但必须是private的，它默认的也是private的。
          枚举项的用法比较特殊：枚举("");
        7.枚举类也可以有抽象方法，但是枚举项必须重写该方法
    */

        //第二个特点的演示
        //我们可以通过"枚举类名.枚举项名称"去访问指定的枚举项
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
        System.out.println("-----------------------------");
        //第三个特点的演示
        //每一个枚举项其实就是该枚举的一个对象
        //Season spring = Season.SPRING;

        //String name() 获取枚举项的名称
        String name = Season.SPRING.name();
        System.out.println(name);
        System.out.println("-----------------------------");

//        int ordinal() 返回枚举项在枚举类中的索引值
        int index1 = Season.SPRING.ordinal();
        int index2 = Season.SUMMER.ordinal();
        int index3 = Season.AUTUMN.ordinal();
        int index4 = Season.WINTER.ordinal();
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
        System.out.println(index4);
        System.out.println("-----------------------------");

//        int compareTo(E o) 比较两个枚举项，返回的是索引值的差值
        int result = Season.SPRING.compareTo(Season.WINTER);
        System.out.println(result);//-3
        System.out.println("-----------------------------");

//        String toString()   返回枚举常量的名称
        String s = Season.SPRING.toString();
        System.out.println(s);
        System.out.println("-----------------------------");

//        static <T> T valueOf(Class<T> type,String name)
//        获取指定枚举类中的指定名称的枚举值
        Season spring = Enum.valueOf(Season.class, "SPRING");
        System.out.println(spring);
        System.out.println(Season.SPRING == spring);
        System.out.println("-----------------------------");

//        values()       获得所有的枚举项
        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value);
        }
    }
}
