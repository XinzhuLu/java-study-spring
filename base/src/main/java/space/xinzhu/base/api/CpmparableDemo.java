package space.xinzhu.base.api;

import java.util.TreeSet;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class CpmparableDemo implements Comparable<CpmparableDemo> {

    private String name;
    private int age;

    public CpmparableDemo() {
    }

    public CpmparableDemo(String name, int age) {
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
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(CpmparableDemo o) {
        //按照对象的年龄进行排序
        //主要判断条件: 按照年龄从小到大排序
        int result = o.age- this.age ;
        //次要判断条件: 年龄相同时，按照姓名的字母顺序排序
        result = result == 0 ? this.name.compareTo(o.getName()) : result;
        return result;
    }

    public static void main(String[] args) {
        //创建集合对象
        TreeSet<CpmparableDemo> ts = new TreeSet<>();
        //创建学生对象
        CpmparableDemo s1 = new CpmparableDemo("zhangsan",28);
        CpmparableDemo s2 = new CpmparableDemo("lisi",27);
        CpmparableDemo s3 = new CpmparableDemo("wangwu",29);
        CpmparableDemo s4 = new CpmparableDemo("zhaoliu",28);
        CpmparableDemo s5 = new CpmparableDemo("qianqi",30);
        //把学生添加到集合
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        //遍历集合
        for (CpmparableDemo student : ts) {
            System.out.println(student);
        }
    }
}
