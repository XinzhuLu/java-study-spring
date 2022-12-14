package space.xinzhu.base.clazz;

import space.xinzhu.base.entry.Student;

import java.lang.reflect.Field;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/09
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class ReflectFieldDemo {

    //
    //Field[] getFields()
    //返回所有公共成员变量对象的数组
    //
    //Field[] getDeclaredFields()
    //返回所有成员变量对象的数组
    //
    //Field getField(String name)
    //返回单个公共成员变量对象
    //
    //Field getDeclaredField(String name)
    //返回单个成员变量对象

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
//        Object get(Object obj) 返回由该 Field表示的字段在指定对象上的值。
        //method1();
        //method2();

    }

    private static void method2() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        //1.获取class对象
        Class clazz = Class.forName("space.xinzhu.base.entry.Student");

        //2.获取成员变量Field的对象
        Field field = clazz.getDeclaredField("money");

        //3.取消一下访问检查
        field.setAccessible(true);

        //4.调用get方法来获取值
        //4.1创建一个对象
        Student student = (Student) clazz.newInstance();
        //4.2获取指定对象的money的值
        Object o = field.get(student);

        //5.打印一下
        System.out.println(o);
    }

    private static void method1() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        //        void set(Object obj, Object value)：给obj对象的成员变量赋值为value
        //1.获取class对象
        Class clazz = Class.forName("space.xinzhu.base.entry.Student");

        //2.获取name这个Field对象
        Field field = clazz.getField("name");

        //3.利用set方法进行赋值.
        //3.1先创建一个Student对象
        Student student = (Student) clazz.newInstance();
        //3.2有了对象才可以给指定对象进行赋值
        field.set(student,"zhangsan");

        System.out.println(student);
    }
}
