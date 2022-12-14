package space.xinzhu.base.io;

import java.io.File;
import java.io.IOException;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class FileDemo {
    public static void main(String[] args) throws IOException {
        //File(String pathname): 通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例
        File f1 = new File("E:\\itcast\\java.txt");
        System.out.println(f1);

        //File(String parent, String child): 从父路径名字符串和子路径名字符串创建新的 File实例
        File f2 = new File("E:\\itcast","java.txt");
        System.out.println(f2);

        //File(File parent, String child): 从父抽象路径名和子路径名字符串创建新的 File实例
        File f3 = new File("E:\\itcast");
        File f4 = new File(f3,"java.txt");
        System.out.println(f4);

        //需求1：我要在E:\\itcast目录下创建一个文件java.txt
        File f5 = new File("E:\\itcast\\java.txt");
        System.out.println(f5.createNewFile());
        System.out.println("--------");

        //需求2：我要在E:\\itcast目录下创建一个目录JavaSE
        File f6 = new File("E:\\itcast\\JavaSE");
        System.out.println(f2.mkdir());
        System.out.println("--------");

        //需求3：我要在E:\\itcast目录下创建一个多级目录JavaWEB\\HTML
        File f7 = new File("E:\\itcast\\JavaWEB\\HTML");
//        System.out.println(f3.mkdir());
        System.out.println(f3.mkdirs());
        System.out.println("--------");

        //需求4：我要在E:\\itcast目录下创建一个文件javase.txt
        File f8 = new File("E:\\itcast\\javase.txt");
//        System.out.println(f4.mkdir());
        System.out.println(f8.createNewFile());

        System.out.println(f8.delete());

        System.out.println(f7.isDirectory());
        System.out.println(f7.isFile());
        System.out.println(f7.exists());

        f7.getAbsolutePath();
        f7.getPath();
        f7.getName();
        f7.listFiles();
    }
}
