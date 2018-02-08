package com.gzq.thread.basic.create;

/**
 * 通过实现Runnable类来创建自己的线程。
 * @author GeYi
 *
 */
public class T2Runnable implements Runnable{

    public static void main(String[] args) {
        T2Runnable target = new T2Runnable();
        Thread thread = new Thread(target );
        thread.setName("myThread");
        thread.start();
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
            
            System.out.println("myThread线程还在工作，对应的线程名称和id：" + Thread.currentThread().getName()
                    + " - " + Thread.currentThread().getId());
        }
    }
    
}
