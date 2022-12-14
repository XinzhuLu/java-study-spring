package space.xinzhu.base.absAndInt;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/05
 * --------------------------------------------
 * 接口就是更加纯粹的抽象类
 **/
public interface Runnable {
    //接口只能定义静态属性，不能定义成员变量，必须用static和final修饰
    //没有构造器
    public static final String NAME="螃蟹";

    //java8之前只能定义抽象方法
    public abstract void run();

    //java8之后可以定义静态方法
    default void defaultMethod(){
        System.out.println("default方法");
    }
    static void staticMethod(){
        System.out.println("static方法");
    }


}
