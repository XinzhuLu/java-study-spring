package space.xinzhu.base;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import space.xinzhu.base.entry.Father;
import space.xinzhu.base.entry.Son;

import java.util.Random;
import java.util.Scanner;

@SpringBootTest
class BaseApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("hello world");
    }

    @Test
    void typeTest() {
        double num = 10; // 将int类型的10直接赋值给double类型
        System.out.println(num); // 输出10.0
        byte a = 12;
        int b = a;
        System.out.println(b); // 12

        int a1 = 'a';
        System.out.println(a1); // 将输出97

        byte b1 = 10;
        byte b2 = 20;
        //byte b3 = b1 + b2;
        // 第三行代码会报错，b1和b2会自动转换为int类型，计算结果为int，int赋值给byte需要强制类型转换。
        // 修改为:
        int num1 = b1 + b2;
        // 或者：
        byte b3 = (byte) (b1 + b2);
    }

    @Test
    void operationTest() {
        // 可以通过使用字符与整数做算术运算，得出字符对应的数值是多少
        char ch1 = 'a';
        System.out.println(ch1 + 1); // 输出98，97 + 1 = 98

        char ch2 = 'A';
        System.out.println(ch2 + 1); // 输出66，65 + 1 = 66

        char ch3 = '0';
        System.out.println(ch3 + 1); // 输出49，48 + 1 = 49
        System.out.println("itheima" + 666); // 输出：itheima666
        System.out.println(1 + 99 + "年黑马"); // 输出：199年黑马
        System.out.println(1 + 2 + "itheima" + 3 + 4); // 输出：3itheima34
        // 可以使用小括号改变运算的优先级
        System.out.println(1 + 2 + "itheima" + (3 + 4)); // 输出：3itheima7

        short s = 10;
        //s = s + 10; // 此行代码报出，因为运算中s提升为int类型，运算结果int赋值给short可能损失精度

        s += 10; // 此行代码没有问题，隐含了强制类型转换，相当于 s = (short) (s + 10);

        int x = 10;
        int y = x++ + x++ + x++;
        System.out.println(y); // y的值是多少？
        /*
        解析，三个表达式都是++在后，所以每次使用的都是自增前的值，但程序自左至右执行，所以第一次自增时，使用的是10进行计算，但第二次自增时，x的值已经自增到11了，所以第二次使用的是11，然后再次自增。。。
        所以整个式子应该是：int y = 10 + 11 + 12;
        输出结果为33。
        */
    }

    @Test
    void scannerTest(){
        //小明的考试成绩未知，可以使用键盘录入的方式获取值
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个分数：");
        int score = sc.nextInt();
        //由于奖励种类较多，属于多种判断，采用if...else...if格式实现
        //为每种判断设置对应的条件
        //为每种判断设置对应的奖励
        //数据测试：正确数据，边界数据，错误数据
        if(score>100 || score<0) {
            System.out.println("你输入的分数有误");
        } else if(score>=95 && score<=100) {
            System.out.println("山地自行车一辆");
        } else if(score>=90 && score<=94) {
            System.out.println("游乐场玩一次");
        } else if(score>=80 && score<=89) {
            System.out.println("变形金刚玩具一个");
        } else {
            System.out.println("胖揍一顿");
        }
    }

    @Test
    void functionTest() {
        //1.定义存放奖金的数组
        int[] arr = {10000,1000,588,888,2};
        //2.定义数组存放已经被取过的奖金
        int[] brr = new int[5];
        //3.定义变量表示brr的索引
        int index = 0;
        //4.创建随机数对象
        Random r = new Random();
        //5.定义循环反复获取随机数,如果index小于arr的长度则继续循环
        while(index < arr.length){
            //5.1每次生成一个随机索引对应一个奖金
            int i = r.nextInt(arr.length);
            //5.2调用方法判断这个奖金是否被获取过
            boolean b = exist(brr, arr[i]);
            //5.3b是false代表这个奖金没有被抽取过
            if(!b) {
                //5.4把获取之后的奖金存放到brr中
                brr[index] = arr[i];
                //5.5index索引向后移动一次
                index++;
                //5.6打印本次被抽出的奖项
                System.out.println( arr[i] + "元的奖金被抽出");
            }
        }
    }
    //6.定义方法：判断brr数组中是否存在num这个数字
    public static boolean exist(int[] brr,int num){
        //6.1对数组进行遍历
        for (int i = 0; i < brr.length; i++) {
            //6.2判断如果找到数字，则返回true
            if(brr[i] == num){
                return true;
            }
        }
        //6.3如果最终没有找到则返回false
        return false;
    }

    @Test
    void privateTest(){
        Father father = new Father(30 ,1 , 500 , "papa" );
/*        father.privateTest(father);
        father.defaultTest(father);
        father.protectTest(father);
        father.publicTest(father);*/
    }

}
