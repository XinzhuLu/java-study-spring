package space.xinzhu.base.io;

import java.nio.ByteBuffer;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/07
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class ByteBufferDemo {
    public static void main(String[] args) {

        //wrapTest();

        //allocateTest();

        ByteBuffer wrap = ByteBuffer.wrap("aaa".getBytes());
        for (int i = 0; i < 3; i++) {
            System.out.println(wrap.get());
        }
    }

    private static void wrapTest() {
        byte [] bytes = {97,98,99};
        //static  ByteBuffer  wrap(byte[] array)创建一个有内容的byte类型缓冲区 |
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(bytes);
        //缓冲区的长度3
        //缓冲区里面的内容就是字节数组的内容.
        for (int i = 0; i < 3; i++) {
            System.out.println(byteBuffer2.get());
        }
        System.out.println(byteBuffer2.get());
    }

    private static void allocateTest() {
        //static  ByteBuffer  allocate(长度)创建byte类型的缓冲区
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(5);
        //get
        for (int i = 0; i < 5; i++) {
            System.out.println(byteBuffer1.get());
        }
        System.out.println(byteBuffer1.get());
    }

    public void otherMethods() {
//        int position()		  当前要操作的索引
//        int limit() 		  最多能操作到哪个索引
//        int capacity()		  缓冲区的总长度
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println(byteBuffer.position());//0
        System.out.println(byteBuffer.limit());//10
        System.out.println(byteBuffer.capacity());//10

//        put(byte b)		  一次添加一个字节
//        byteBuffer.put((byte) 97);
//        System.out.println(byteBuffer.position());
//        System.out.println(byteBuffer.limit());
//        System.out.println(byteBuffer.capacity());

//        put(byte[] src)		 一次添加一个字节数组
//        byteBuffer.put("aaa".getBytes());
//        System.out.println(byteBuffer.position());//3
//        System.out.println(byteBuffer.limit());//10
//        System.out.println(byteBuffer.capacity());//10

//        position(int newPosition) 修改position
//        byteBuffer.position(1);

//        limit(int newLimit)	  修改limit
//        byteBuffer.limit(5);
//        System.out.println(byteBuffer.position());
//        System.out.println(byteBuffer.limit());
//        System.out.println(byteBuffer.capacity());

//        int remaining()		  还有多少能操作
//        boolean hasRemaining()	  是否还有能操作的

        byteBuffer.put("0123456789".getBytes());
        System.out.println(byteBuffer.remaining());
        System.out.println(byteBuffer.hasRemaining());
    }

    public void test() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put("abc".getBytes());

//        flip()  切换读写模式（写读）
        byteBuffer.flip();
//        get()   读一个字节
//        while(byteBuffer.limit() != byteBuffer.position()){
//            System.out.println((char) byteBuffer.get());
//        }

        for (int i = 0; i < byteBuffer.limit(); i++) {
            System.out.println((char) byteBuffer.get());
        }

//        get(byte[] dst) 读多个字节
//        byte [] bytes = new byte[byteBuffer.limit()];
//        byteBuffer.get(bytes);
//        System.out.println(new String(bytes));

//        get(int index)  读指定索引的字节
//        System.out.println((char) byteBuffer.get(0));

//        rewind()    将position设置为0，可以重复读
//        byteBuffer.rewind();
//        for (int i = 0; i < byteBuffer.limit(); i++) {
//            System.out.println((char) byteBuffer.get());
//        }

//        clear()     数据读写完毕（读->写）
        byteBuffer.clear();
        byteBuffer.put("qqq".getBytes());
//        array()     将缓冲区转换成字节数组返回

        byte[] bytes = byteBuffer.array();
        System.out.println(new String(bytes));
    }
}
