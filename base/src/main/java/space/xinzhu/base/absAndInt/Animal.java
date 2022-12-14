package space.xinzhu.base.absAndInt;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/05
 * --------------------------------------------
 * 抽象类可以定义构造方法，从而限制继承类的构造
 **/
public abstract class Animal {

    protected String name;

    public abstract void eat();

    public Animal(String name){
        this.name = name;
    }
}
