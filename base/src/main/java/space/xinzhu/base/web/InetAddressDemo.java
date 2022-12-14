package space.xinzhu.base.web;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/07
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        //InetAddress address = InetAddress.getByName("itheima");
        //InetAddress address = InetAddress.getByName("baidu");报错
        InetAddress address = InetAddress.getByName("www.baidu.com");

        //public String getHostName()：获取此IP地址的主机名
        String name = address.getHostName();
        //public String getHostAddress()：返回文本显示中的IP地址字符串
        String ip = address.getHostAddress();

        System.out.println("主机名：" + name);
        System.out.println("IP地址：" + ip);
    }
}
