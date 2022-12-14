package space.xinzhu.base.api;

import java.util.ArrayList;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class GenericDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Number> list3 = new ArrayList<>();
        ArrayList<Object> list4 = new ArrayList<>();

        method(list1);
        method(list2);
        method(list3);
        method(list4);

        getElement1(list1);
        //getElement1(list2);//报错
        getElement1(list3);
        //getElement1(list4);//报错

        //getElement2(list1);//报错
        //getElement2(list2);//报错
        getElement2(list3);
        getElement2(list4);
    }

    // 泛型通配符: 此时的泛型?,可以是任意类型
    public static void method(ArrayList<?> list){}
    // 泛型的上限: 此时的泛型?,必须是Number类型或者Number类型的子类
    public static void getElement1(ArrayList<? extends Number> list){}
    // 泛型的下限: 此时的泛型?,必须是Number类型或者Number类型的父类
    public static void getElement2(ArrayList<? super Number> list){}
}
