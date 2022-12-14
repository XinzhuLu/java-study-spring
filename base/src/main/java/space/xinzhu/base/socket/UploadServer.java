package space.xinzhu.base.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/07
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class UploadServer {
    public static void main(String[] args) throws IOException {
        //创建服务端ServerSocket对象，绑定端口号
        ServerSocket server=new ServerSocket(10010);

        //监听客户端
        Socket socket = server.accept();

        //创建本地输出流
        File filename=new File("/Users/itheima/Desktop/upload", UUID.randomUUID()+".jpeg");
        FileOutputStream fos=new FileOutputStream(filename);

        //获取读取网络数据的流
        InputStream in = socket.getInputStream();
        byte[] bs=new byte[1024];
        int len; //记录每次读取的字节个数
        while ((len=in.read(bs))!=-1){
            //把读取到的数据写到服务端
            fos.write(bs,0,len);
        }
        fos.close();

        //往服务端写一个反馈信息"上传成功"
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("上传成功");
        bw.newLine();
        bw.flush();

        socket.close();
        server.close();
    }
}
