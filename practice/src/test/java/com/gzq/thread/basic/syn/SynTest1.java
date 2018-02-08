package com.gzq.thread.basic.syn;

/**
 * 静态和类监视。
 * 
 * @author GeYi
 *
 */
public class SynTest1 extends Thread {
    // 多线程共享资源
    public static int sum = 0;

    @Override
    public void run() {
        // count();//静态方法由于只有一份，所以所有调用该方法的线程都会同步
        // count2();//监视类也只有一个，所以所有调用该方法的线程都会同步
        
//        count3();//非静态方法是一个对象一份，所以这里测试时多个对象并没有同步
//        count4();//监视this也是一样各自的对象无法同步.
        count5();//监视对象的改良版.
    }

    public synchronized static void count() {
        for (int i = 0; i < 20; i++) {
            Thread.yield();
            sum++;
        }
        System.out.println(sum);
    }

    public void count2() {
        synchronized (SynTest1.class) {
            for (int i = 0; i < 20; i++) {
                Thread.yield();
                sum++;
            }
            System.out.println(sum);

        }
    }

    public synchronized void count3() {
        for (int i = 0; i < 20; i++) {
            Thread.yield();
            sum++;
        }
        System.out.println(sum);
    }
    
    public void count4() {
        synchronized(this) {
            for (int i = 0; i < 20; i++) {
                Thread.yield();
                sum++;
            }
            System.out.println(sum);
            
        }
    }
    
    public static Object object = new Object();
    public void count5() {
        synchronized(object) {
            for (int i = 0; i < 20; i++) {
                Thread.yield();
                sum++;
            }
            System.out.println(sum);
            
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new SynTest1_2().start();
        }
    }

}

class SynTest1_2 extends SynTest1 {

}
