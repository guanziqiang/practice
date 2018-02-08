package com.gzq.thread.basic.join;

/**
 * 测试join系列三个方法的效果，并尝试中途使用notify去唤醒join。
 * join方法的逻辑：就是让调用线程wait在被调用线程的关联对象的等待区。
 * @author GeYi
 *
 */
public class Join1 {

    public volatile static int i = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (i = 0; i < 10000000; i++) {
                if (i == 100) {
                    synchronized (this) {
                        // join的源代码中时靠wait方法来实现的，所以这里尝试使用notifyAll去打扰join方法。
                        this.notifyAll();
                        System.out.println("addThread object of hashCode is "
                                + this.hashCode() + " in this run method");
                        currentThread().notifyAll();
                        System.out.println("addThread currentThread method of hashcode is " + currentThread().hashCode());
                    }
                }
            }
            ;
            System.out.println("addthread thead end , i is" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        System.out.println("addThread object of hashCode is " + addThread.hashCode());
        addThread.start();
        try {
            // addThread.join(10, 500000);//这个比较蛋疼。
            // addThread.join(3);//直到被调用线程wait 3秒后，调用线程才继续执行。
            addThread.join();//直到被调用线程运行完成，调用线程才继续执行。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // if join is effective, main thread i value is 10000000
        System.out.println("main end，i is " + i);
    }

}
