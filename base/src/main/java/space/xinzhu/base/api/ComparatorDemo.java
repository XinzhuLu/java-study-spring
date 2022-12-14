package space.xinzhu.base.api;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class ComparatorDemo {
    private String name;
    private int age;

    public ComparatorDemo() {
    }

    public ComparatorDemo(String name, int age) {
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
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        //创建集合对象
        TreeSet<ComparatorDemo> ts = new TreeSet<>(new Comparator<ComparatorDemo>() {
            @Override
            public int compare(ComparatorDemo o1, ComparatorDemo o2) {
                //o1表示现在要存入的那个元素
                //o2表示已经存入到集合中的元素

                //主要条件
                int result = o1.getAge() - o2.getAge();
                //次要条件
                result = result == 0 ? o1.getName().compareTo(o2.getName()) : result;
                return result;
            }
        });
        //创建老师对象
        ComparatorDemo t1 = new ComparatorDemo("zhangsan",23);
        ComparatorDemo t2 = new ComparatorDemo("lisi",22);
        ComparatorDemo t3 = new ComparatorDemo("wangwu",24);
        ComparatorDemo t4 = new ComparatorDemo("zhaoliu",24);
        //把老师添加到集合
        ts.add(t1);
        ts.add(t2);
        ts.add(t3);
        ts.add(t4);
        //遍历集合
        for (ComparatorDemo teacher : ts) {
            System.out.println(teacher);
        }
    }
}
