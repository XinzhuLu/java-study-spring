package space.xinzhu.base.io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        //创建字节输出流对象
      	/*
      		注意点:
      				1.如果文件不存在,会帮我们创建
      				2.如果文件存在,会把文件清空
      	*/
        //FileOutputStream(String name)：创建文件输出流以指定的名称写入文件
        FileOutputStream fos = new FileOutputStream("myByteStream\\fos.txt");

        //void write(int b)：将指定的字节写入此文件输出流
        fos.write(97);
//        fos.write(57);
//        fos.write(55);

        //最后都要释放资源
        //void close()：关闭此文件输出流并释放与此流相关联的任何系统资源。
        fos.close();

        //FileOutputStream(String name)：创建文件输出流以指定的名称写入文件
        FileOutputStream fos2 = new FileOutputStream("myByteStream\\fos.txt");
        //FileOutputStream(File file)：创建文件输出流以写入由指定的 File对象表示的文件
//        FileOutputStream fos = new FileOutputStream(new File("myByteStream\\fos.txt"));

        //void write(int b)：将指定的字节写入此文件输出流
//        fos.write(97);
//        fos.write(98);
//        fos.write(99);
//        fos.write(100);
//        fos.write(101);

//        void write(byte[] b)：将 b.length字节从指定的字节数组写入此文件输出流
//        byte[] bys = {97, 98, 99, 100, 101};
        //byte[] getBytes()：返回字符串对应的字节数组
        byte[] bys = "abcde".getBytes();
//        fos.write(bys);

        //void write(byte[] b, int off, int len)：将 len字节从指定的字节数组开始，从偏移量off开始写入此文件输出流
//        fos.write(bys,0,bys.length);
        fos.write(bys, 1, 3);

        //释放资源
        fos2.close();

        //创建字节输出流对象
//        FileOutputStream fos = new FileOutputStream("myByteStream\\fos.txt");
        FileOutputStream fos3 = new FileOutputStream("myByteStream\\fos.txt",true);

        //写数据
        for (int i = 0; i < 10; i++) {
            fos3.write("hello".getBytes());
            fos3.write("\r\n".getBytes());
        }

        //释放资源
        fos3.close();
    }
}
