package space.xinzhu.base.web;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/09
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class AcceptHandlerDemo {
    public SocketChannel connSocketChannel(SelectionKey selectionKey){
        try {
            //获取到已经就绪的服务端通道
            ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
            SocketChannel socketChannel = ssc.accept();
            //设置为非阻塞状态
            socketChannel.configureBlocking(false);
            //把socketChannel注册到选择器上
            socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ);
            return socketChannel;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
