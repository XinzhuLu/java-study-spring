package space.xinzhu.base.clazz;

import space.xinzhu.base.entry.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/09
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class ReflectMethodDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //method1();
        //method2();
        //method3();
        //method4();
        //method5();

        //        Object invoke(Object obj, Object... args)：运行方法
//        参数一：用obj对象调用该方法
//        参数二：调用方法的传递的参数（如果没有就不写）
//        返回值：方法的返回值（如果没有就不写）

        //1.获取class对象
        Class clazz = Class.forName("com.itheima.myreflect5.Student");
        //2.获取里面的Method对象  function4
        Method method = clazz.getMethod("function4", String.class);
        //3.运行function4方法就可以了
        //3.1创建一个Student对象,当做方法的调用者
        Student student = (Student) clazz.newInstance();
        //3.2运行方法
        Object result = method.invoke(student, "zhangsan");
        //4.打印一下返回值
        System.out.println(result);
    }


    private static void method5() throws ClassNotFoundException, NoSuchMethodException {
        //        Method getDeclaredMethod(String name, Class<?>... parameterTypes)：
//                                返回单个成员方法对象
        //1.获取class对象
        Class clazz = Class.forName("com.itheima.myreflect5.Student");
        //2.获取一个成员方法show
        Method method = clazz.getDeclaredMethod("show");
        //3.打印一下
        System.out.println(method);
    }

    private static void method4() throws ClassNotFoundException, NoSuchMethodException {
        //1.获取class对象
        Class clazz = Class.forName("com.itheima.myreflect5.Student");
        //2.获取一个有形参的方法function2
        Method method = clazz.getMethod("function2", String.class);
        //3.打印一下
        System.out.println(method);
    }

    private static void method3() throws ClassNotFoundException, NoSuchMethodException {
        //        Method getMethod(String name, Class<?>... parameterTypes) ：
//                                返回单个公共成员方法对象
        //1.获取class对象
        Class clazz = Class.forName("com.itheima.myreflect5.Student");
        //2.获取成员方法function1
        Method method1 = clazz.getMethod("function1");
        //3.打印一下
        System.out.println(method1);
    }

    private static void method2() throws ClassNotFoundException {
        //        Method[] getDeclaredMethods()：
//                                返回所有成员方法对象的数组，不包括继承的
        //1.获取class对象
        Class clazz = Class.forName("com.itheima.myreflect5.Student");

        //2.获取Method对象
        Method[] methods = clazz.getDeclaredMethods();
        //3.遍历一下数组
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    private static void method1() throws ClassNotFoundException {
        //        Method[] getMethods()：返回所有公共成员方法对象的数组，包括继承的
        //1.获取class对象
        Class clazz = Class.forName("com.itheima.myreflect5.Student");
        //2.获取成员方法对象
        Method[] methods = clazz.getMethods();
        //3.遍历
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
