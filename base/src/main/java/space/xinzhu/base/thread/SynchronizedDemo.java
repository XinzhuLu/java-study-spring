package space.xinzhu.base.thread;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class SynchronizedDemo implements Runnable{
    private static int ticketCount = 100;

    @Override
    public void run() {
        while(true){
            if("窗口一".equals(Thread.currentThread().getName())){
                //同步方法
                boolean result = synchronizedMthod();
                if(result){
                    break;
                }
            }

            if("窗口二".equals(Thread.currentThread().getName())){
                //同步代码块
                synchronized (SynchronizedDemo.class){
                    if(ticketCount == 0){
                        break;
                    }else{
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ticketCount--;
                        System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + ticketCount + "张票");
                    }
                }
            }

        }
    }

    private static synchronized boolean synchronizedMthod() {
        if(ticketCount == 0){
            return true;
        }else{
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticketCount--;
            System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + ticketCount + "张票");
            return false;
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo mr = new SynchronizedDemo();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);

        t1.setName("窗口一");
        t2.setName("窗口二");

        t1.start();
        t2.start();
    }
}
