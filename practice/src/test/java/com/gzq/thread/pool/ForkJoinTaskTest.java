package com.gzq.thread.pool;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 使用ForkJoinPool做一个任务分解 和 结果合并的案例
 * @author GeYi
 *
 */
public class ForkJoinTaskTest extends RecursiveTask<Long>{
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTaskTest task = new ForkJoinTaskTest(3, 20000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        try {
            long res = result.get();
            System.out.println("sum : " + res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        
    }
    
    private static final long serialVersionUID = 1L;
    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public ForkJoinTaskTest(long start, long end) {
        super();
        this.start = start;
        this.end = end;
    }
    
    public Long compute() {
        long sum = 0;
        boolean canCompute = (end-start) < THRESHOLD;
        if (canCompute) {
            for (long i = start; i <= end; i++) {
                sum +=i;
            }
        }else {
            long step = (start+end)/100;
            ArrayList<ForkJoinTaskTest> subTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                if(lastOne > end)
                    lastOne = end;
                ForkJoinTaskTest subTask = new ForkJoinTaskTest(pos, lastOne);
                pos += step+1;
                subTasks.add(subTask);
                subTask.fork();//分解任务
            }
            for (ForkJoinTaskTest forkJoinTaskTest : subTasks) {
                sum += forkJoinTaskTest.join();//
            }
        }
        return sum;
    }

}
