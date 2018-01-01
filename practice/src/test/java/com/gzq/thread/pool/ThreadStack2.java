package com.gzq.thread.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 扩展ThreadPoolExecutor,以得到完整的异常信息。
 * 
 * @author GeYi
 *
 */
public class ThreadStack2 extends ThreadPoolExecutor {
    
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadStack2(0, Integer.MAX_VALUE, 0L,
                TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 5; i++) {
            executor.execute(new DivTask(100, i));
        }
    }
    


    public ThreadStack2(int corePoolSize, int maximumPoolSize, long keepAliveTime,
            TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable task) {
        super.execute(wrap(task, clientTrack(), Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(
                wrap(task, clientTrack(), Thread.currentThread().getName()));
    }

    private Exception clientTrack() {
        return new Exception("Client stack tarce");
    }

    private Runnable wrap(final Runnable task, final Exception clientStack,
            String clientThreadName) {
        return new Runnable() {

            @Override
            public void run() {
                try {
                    task.run();
                } catch (Exception e) {
                    clientStack.printStackTrace();
                    throw e;
                }
            }
        };
    }

}

class DivTask implements Runnable{

    int a, b;
    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void run() {
        double result = a/b;
        System.out.println(result);
    }
}

