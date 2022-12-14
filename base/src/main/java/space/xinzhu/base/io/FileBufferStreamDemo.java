package space.xinzhu.base.io;

import java.io.*;
import java.util.Arrays;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class FileBufferStreamDemo {
    public static void main(String[] args) throws IOException {

        //复制视频
//        method1();
        method2();

        //定义一个字符串
        String s = "中国";

        //byte[] bys = s.getBytes(); //[-28, -72, -83, -27, -101, -67]
        //byte[] bys = s.getBytes("UTF-8"); //[-28, -72, -83, -27, -101, -67]
        byte[] bys = s.getBytes("GBK"); //[-42, -48, -71, -6]
        System.out.println(Arrays.toString(bys));

        //String ss = new String(bys);
        //String ss = new String(bys,"UTF-8");
        String ss = new String(bys,"GBK");
        System.out.println(ss);

    }

    //字节缓冲流一次读写一个字节数组
    public static void method2() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\itcast\\字节流复制图片.avi"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("myByteStream\\字节流复制图片.avi"));

        byte[] bys = new byte[1024];
        int len;
        while ((len=bis.read(bys))!=-1) {
            bos.write(bys,0,len);
        }

        bos.close();
        bis.close();
    }

    //字节缓冲流一次读写一个字节
    public static void method1() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\itcast\\字节流复制图片.avi"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("myByteStream\\字节流复制图片.avi"));

        int by;
        while ((by=bis.read())!=-1) {
            bos.write(by);
        }

        bos.close();
        bis.close();
    }
}
