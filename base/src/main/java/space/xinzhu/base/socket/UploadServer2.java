package space.xinzhu.base.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/07
 * --------------------------------------------
 * 死循环监听客户端，不断的处理文件上传的任务
 **/
public class UploadServer2 {
    public static void main(String[] args) throws IOException {
        //创建服务端ServerSocket对象，绑定端口号
        ServerSocket server=new ServerSocket(10010);

        while (true){
            //监听客户端
            Socket socket = server.accept(); //阻塞
            //创建线程并执行
            new Thread(new UploadRunnable(socket)).start();
        }

        //server.close();
    }
}
