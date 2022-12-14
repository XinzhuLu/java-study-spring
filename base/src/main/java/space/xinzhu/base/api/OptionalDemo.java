package space.xinzhu.base.api;

import space.xinzhu.base.clone.Student;

import java.util.Optional;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class OptionalDemo {
    public static void main(String[] args) {
        //method1();

        //public static <T> Optional<T> ofNullable(T value)
        //获取一个Optional对象，Optional封装的值对象可以是null也可以不是null
        //Student s = new Student("zhangsan",23);
        Student s = null;
        //ofNullable方法，封装的对象可以是null，也可以不是null。
        Optional<Student> optional = Optional.ofNullable(s);
        //Optional<Student> optional2 = Optional.of(s);

        System.out.println(optional);
        //System.out.println(optional2);

        //如果封装的是一个null，那么通过get方法再次获取会抛出NoSuchElementException。
        if(optional.isPresent()){
            Student student = optional.get();
            System.out.println(student);
        }else{
            System.out.println("Optional封装的对象为空");
        }
    }

    private static void method1() {
        //static <T> Optional<T> of(T value)    获取一个Optional对象，封装的是非null值的对象

        //Student s = new Student("zhangsan",23);
        Student s = null;
        //Optional可以看做是一个容器，里面装了一个引用数据类型的对象。
        //返回值就是Optional的对象
        //如果使用of方法，封装的对象如果为空，那么还是会抛出空指针异常
        Optional<Student> optional1 = Optional.of(s);
        System.out.println(optional1);
    }
}
