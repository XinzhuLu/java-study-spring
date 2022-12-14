package space.xinzhu.base.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class CollectionsDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(100);
        list.add(300);
        list.add(200);
        list.add(400);
        //排序方法
        Collections.sort(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(list);

        Object o = new Object();
        o.hashCode();
    }
}
