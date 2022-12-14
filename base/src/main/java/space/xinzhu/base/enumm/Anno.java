package space.xinzhu.base.enumm;

import java.lang.annotation.*;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/10
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})  //指定注解使用的位置（成员变量，类，方法）
@Retention(RetentionPolicy.RUNTIME) //指定该注解的存活时间
@Inherited //指定该注解可以被继承
public @interface Anno {
}
