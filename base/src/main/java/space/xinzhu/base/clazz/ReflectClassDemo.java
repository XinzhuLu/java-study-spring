package space.xinzhu.base.clazz;

import java.lang.reflect.Constructor;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/09
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class ReflectClassDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        System.out.println("----------0------------");
        method1();
        System.out.println("----------1------------");
        method2();
        System.out.println("----------2------------");
        method3();
        System.out.println("----------3------------");
        //method4();
        System.out.println("----------4------------");
    }

    private static void method4() throws ClassNotFoundException, NoSuchMethodException {
        //        Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)：
//                                      返回单个构造方法对象
        //1.获取Class对象
        Class clazz = Class.forName("space.xinzhu.base.entry.Father");
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        System.out.println(constructor);
    }

    private static void method3() throws ClassNotFoundException, NoSuchMethodException {
        //        Constructor<T> getConstructor(Class<?>... parameterTypes)：
//                                      返回单个公共构造方法对象
        //1.获取Class对象
        Class clazz = Class.forName("space.xinzhu.base.entry.Father");
        //小括号中,一定要跟构造方法的形参保持一致.
        Constructor constructor1 = clazz.getConstructor();
        System.out.println(constructor1);

        Constructor constructor2 = clazz.getConstructor(int.class, int.class , int.class , String.class);
        System.out.println(constructor2);

        //因为Student类中,没有只有一个int的构造,所以这里会报错.
        Constructor constructor3 = clazz.getConstructor(int.class ,String.class);
        System.out.println(constructor3);
    }

    private static void method2() throws ClassNotFoundException {
        //        Constructor<?>[] getDeclaredConstructors()：
//                                      返回所有构造方法对象的数组
        //1.获取Class对象
        Class clazz = Class.forName("space.xinzhu.base.entry.Father");

        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }

    private static void method1() throws ClassNotFoundException {
        //        Constructor<?>[] getConstructors()：
//                                      返回所有公共构造方法对象的数组
        //1.获取Class对象
        Class clazz = Class.forName("space.xinzhu.base.entry.Father");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }
}
