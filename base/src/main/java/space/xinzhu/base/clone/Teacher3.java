package space.xinzhu.base.clone;

import com.google.gson.Gson;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/05
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class Teacher3 {


    private String name;
    private int age;
    private Student stu;

    public static void main(String[] args) {
        Student stu = new Student("李四", 24);
        Teacher3 tea = new Teacher3("张三", 30, stu);
        /*使用Gson工具*/
        Gson gson = new Gson();
        //将对象序列化为json字符串
        String teaStr = gson.toJson(tea);
        //然后将字符串反序列化为对象
        Teacher3 GsonTea = gson.fromJson(teaStr, Teacher3.class);

        /*clone之后改变原对象的数据*/
        //改变stu的数据
        stu.name = "李四改";
        //改变tea的数据
        tea.name = "张三改";

        /*结果被克隆的数据的内部类的stu数据没受到了影响,说明使用JSON工具,实现的是深克隆,tea的对象类型属性stu不是指向同一个对象*/
        System.out.println(GsonTea);
        System.out.println(tea);
        System.out.println("GsonTea.equals(tea) = " + GsonTea.equals(tea));
    }

    public Teacher3(String name, int age, Student stu) {
        super();
        this.name = name;
        this.age = age;
        this.stu = stu;
    }

    public static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            super();
            this.name = name;
            this.age = age;
        }


        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Teacher3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", stu=" + stu +
                '}';
    }
}

