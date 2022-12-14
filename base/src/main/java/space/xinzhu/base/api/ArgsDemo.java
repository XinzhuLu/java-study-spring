package space.xinzhu.base.api;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class ArgsDemo {
    public static void main(String[] args) {
        System.out.println(sum(10, 20));
        System.out.println(sum(10, 20, 30));
        System.out.println(sum(10, 20, 30, 40));

        System.out.println(sum(10,20,30,40,50));
        System.out.println(sum(10,20,30,40,50,60));
        System.out.println(sum(10,20,30,40,50,60,70));
        System.out.println(sum(10,20,30,40,50,60,70,80,90,100));
    }

//    public static int sum(int b,int... a) {
//        return 0;
//    }

    public static int sum(int... a) {
        int sum = 0;
        for(int i : a) {
            sum += i;
        }
        return sum;
    }
}
