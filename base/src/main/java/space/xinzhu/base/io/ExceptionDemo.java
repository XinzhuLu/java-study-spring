package space.xinzhu.base.io;

import space.xinzhu.base.api.AgeOutOfBoundsException;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class ExceptionDemo {

    public static void main(String[] args) {
        System.out.println("开始");
        method();
        System.out.println("结束");
    }

    public static void method() {
        try {
            int[] arr = {1, 2, 3};
            if(true){throw new AgeOutOfBoundsException("hahahahaah");}
            System.out.println(arr[3]); //new ArrayIndexOutOfBoundsException();
            System.out.println("这里能够访问到吗");

        } catch (AgeOutOfBoundsException e){

            System.out.println("----");
            System.out.println(e.toString());
            System.out.println("----");

        }
        catch (ArrayIndexOutOfBoundsException e) { //new ArrayIndexOutOfBoundsException();
//            e.printStackTrace();

            //public String getMessage():返回此 throwable 的详细消息字符串
//            System.out.println(e.getMessage());
            //Index 3 out of bounds for length 3

            //public String toString():返回此可抛出的简短描述
//            System.out.println(e.toString());
            //java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3

            //public void printStackTrace():把异常的错误信息输出在控制台
            e.printStackTrace();
//            java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
//            at com.itheima_02.ExceptionDemo02.method(ExceptionDemo02.java:18)
//            at com.itheima_02.ExceptionDemo02.main(ExceptionDemo02.java:11)

        }
    }

}
