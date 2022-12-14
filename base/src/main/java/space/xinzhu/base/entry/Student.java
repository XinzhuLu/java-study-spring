package space.xinzhu.base.entry;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/09
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class Student {
    private String id;
    private String name;
    private int age;

    public String gender;

    private int money = 300;

    //私有的有参构造方法
    private Student(String name) {
        System.out.println("name的值为:" + name);
        System.out.println("private...Student...有参构造方法");
    }

    public Student(String id ,String name , int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    //公共的无参构造方法
    public Student() {
        System.out.println("public...Student...无参构造方法");
    }

    //公共的有参构造方法
    public Student(String name, int age) {
        System.out.println("name的值为:" + name + "age的值为:" + age);
        System.out.println("public...Student...有参构造方法");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", money=" + money +
                '}';
    }

    //私有的，无参无返回值
    private void show() {
        System.out.println("私有的show方法，无参无返回值");
    }

    //公共的，无参无返回值
    public void function1() {
        System.out.println("function1方法，无参无返回值");
    }

    //公共的，有参无返回值
    public void function2(String name) {
        System.out.println("function2方法，有参无返回值,参数为" + name);
    }

    //公共的，无参有返回值
    public String function3() {
        System.out.println("function3方法，无参有返回值");
        return "aaa";
    }

    //公共的，有参有返回值
    public String function4(String name) {
        System.out.println("function4方法，有参有返回值,参数为" + name);
        return "aaa";
    }
}
