package space.xinzhu.base.socket;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/07
 * --------------------------------------------
 * 服务端多线程优化
 **/
public class UploadRunnable implements Runnable{

    private Socket socket;

    public UploadRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
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

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
