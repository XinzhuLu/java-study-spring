package space.xinzhu.base.api;

import java.util.Arrays;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/05
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class ArraysDemo {
    public static void main(String[] args) {
        //定义一个字符串
        String s = "91 27 46 38 50";

        //把字符串中的数字数据存储到一个int类型的数组中
        String[] strArray = s.split(" ");
        //for(int i=0; i<strArray.length; i++) {
        //System.out.println(strArray[i]);
        //}

        //定义一个int数组，把 String[] 数组中的每一个元素存储到 int 数组中
        int[] arr = new int[strArray.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArray[i]);
        }

        //对 int 数组进行排序
        Arrays.sort(arr);

        Arrays.binarySearch(arr , 27);

        Arrays.toString(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
