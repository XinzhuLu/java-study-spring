package space.xinzhu.base.web;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/07
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class UDPSendDemo {

    public static void main(String[] args) throws IOException {
        //创建发送端的Socket对象(DatagramSocket)
        // DatagramSocket() 构造数据报套接字并将其绑定到本地主机上的任何可用端口
        DatagramSocket ds = new DatagramSocket();

        //键盘录入数据
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            //输入的数据是886，发送数据结束
            if ("886".equals(s)) {
                break;
            }

            //创建数据，并把数据打包
            //DatagramPacket(byte[] buf, int length, InetAddress address, int port)
            //构造一个数据包，发送长度为 length的数据包到指定主机上的指定端口号。
            byte[] bys = s.getBytes();

            DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("127.0.0.1"), 12345);

            //调用DatagramSocket对象的方法发送数据
            //void send(DatagramPacket p) 从此套接字发送数据报包
            ds.send(dp);
        }
        //从此套接字接受数据报包
        //ds.receive(dp);

        //关闭发送端
        //void close() 关闭此数据报套接字
        ds.close();
    }
}
