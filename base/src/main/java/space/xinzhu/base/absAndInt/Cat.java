package space.xinzhu.base.absAndInt;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/05
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class Cat extends Animal implements Runnable{

    private int age;
    @Override
    public void eat() {
        System.out.println("我能吃");
    }

    @Override
    public void run() {
        System.out.println("我能跑");
    }

    @Override
    public void defaultMethod() {
        Runnable.super.defaultMethod();
    }

    public Cat(String name , int age){
        super(name);
        this.age=age;
    }

    public Cat(String name){
        super(name);
    }

    //被抽象类限制构造
    //public Cat(int age){
    //    this.age=age;
    //}
    //public Cat(){}
}
