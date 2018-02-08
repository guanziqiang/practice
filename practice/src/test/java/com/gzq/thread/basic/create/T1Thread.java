package com.gzq.thread.basic.create;

/**
 * 通过继承Thread类来创建自己的线程。
 * @author GeYi
 */
public class T1Thread extends Thread{

    public static void main(String[] args) {
        T1Thread myThread = new T1Thread();
        myThread.setName("myThread");//设置线程名称
        myThread.start();//启动自定义的线程
        System.out.println("main线程执行完成，对应的线程名称和id： " + Thread.currentThread().getName() + " - "
                + Thread.currentThread().getId());
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);//让当前线程休眠2000毫秒，以便在main线程执行完后，该线程还会在运行，方便看到结果。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println("T1Thread线程还在工作，对应的线程名称和id：" + Thread.currentThread().getName()
                    + " - " + Thread.currentThread().getId());
        }
    }
    
}
