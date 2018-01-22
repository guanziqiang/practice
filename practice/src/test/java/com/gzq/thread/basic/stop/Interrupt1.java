package com.gzq.thread.basic.stop;

/**
 * 测试interrupt中断情况下interrupted、isInterrupted方法的差别
 * @author Administrator
 *
 */
public class Interrupt1 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                int count = 0;
                while(true) {
                	//获取并清楚中断状态
                    boolean interrupted = Thread.interrupted();
                    //获取但不清楚中断状态
//                    boolean interrupted = Thread.currentThread().isInterrupted();
                    if(interrupted) {
                        System.out.println("中断状态为真："+interrupted);
                        if(count > 0) {
                            break;
                        }
                        count = 1;//发现中断标识后，再打印一次interrupt的值
                    }else {
                        System.out.println("中断状态为假："+interrupted);
                        if(count > 0) {
                            break;
                        }
                    }
                }
            }
        };
        thread.start();
        Thread.sleep(1000);//主线程休息两秒后中断副线程
        thread.interrupt();
        
    }

}
