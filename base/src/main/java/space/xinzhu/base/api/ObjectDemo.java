package space.xinzhu.base.api;

import java.util.Objects;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/05
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class ObjectDemo implements Cloneable{
    private String name;
    private int age;

    public ObjectDemo() {
    }

    public ObjectDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        //this -- s1
        //o -- s2
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectDemo student = (ObjectDemo) o; //student -- s2

        if (age != student.age) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public String toString() {
        return "ObjectDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ObjectDemo s1 = new ObjectDemo();
        s1.setName("林青霞");
        s1.setAge(30);

        ObjectDemo s2 = new ObjectDemo();
        s2.setName("林青霞");
        s2.setAge(30);

        //需求：比较两个对象的内容是否相同
        System.out.println(s1.equals(s2));

        ObjectDemo s3 = (ObjectDemo)s1.clone();

        s1.setAge(18);
        s1.setName("杨超越");

        System.out.println("Objects.isNull(s1) = " + Objects.isNull(s1));
        System.out.println("Objects.hashCode(s1) = " + Objects.hashCode(s1));
        System.out.println("Objects.hashCode(s2) = " + Objects.hashCode(s2));
        System.out.println("Objects.hashCode(s3) = " + Objects.hashCode(s3));
        System.out.println(s3.equals(s1));
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
    }

}