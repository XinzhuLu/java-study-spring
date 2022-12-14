package space.xinzhu.base.socket;

import java.io.*;
import java.net.Socket;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/07
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class UploadClient {
    public static void main(String[] args) throws IOException {
        //创建Socket对象，绑定服务端的ip和端口号
        Socket socket=new Socket("127.0.0.1",10010);

        //获取通往服务端的输出流
        OutputStream out = socket.getOutputStream();

        //读取本地的a.jpeg图片
        FileInputStream fis=new FileInputStream("day15/a.jpeg");
        byte[] bs=new byte[1024];
        int len; //记录每次读取的字节个数
        while ((len=fis.read(bs))!=-1){
            //把读取到的数据写到服务端
            out.write(bs,0,len);
        }
        //告诉服务端数据写完了
        socket.shutdownOutput();

        //获取服务端返回的数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println(s);

        //释放资源
        socket.close();
    }
}
