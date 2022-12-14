package space.xinzhu.base.enumm;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/10
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class StudentDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取到Student类的字节码文件对象
        Class clazz = Class.forName("space.xinzhu.base.enumm.Student");
        //获取注解。
        boolean result = clazz.isAnnotationPresent(Anno.class);
        System.out.println(result);
    }
}