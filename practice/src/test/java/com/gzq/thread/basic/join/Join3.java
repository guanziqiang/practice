package com.gzq.thread.basic.join;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 测试notify唤醒(或者join到时)多个时对同步的影响。
 * @author GeYi
 */
public class Join3 extends Thread{
    
    public static int count = 0;
    
    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            int myCount = count;
            try {
                Thread.sleep(new Random().nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count = myCount +1;
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        List<Join3> list = new ArrayList<Join3>();
        for(int i=0; i<9; i++) {
            Join3 join3 = new Join3();
            list.add(join3);
        }
        for(Join3 join3 : list) {
            join3.start();
            synchronized (join3) {
                join3.wait();
            }
        }
        System.out.println(count);
    }

}
