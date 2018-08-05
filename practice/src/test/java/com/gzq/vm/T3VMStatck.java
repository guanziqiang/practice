package com.gzq.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过多线程的方式抛出java.lang.OutOfMemory异常
 * @author Administrator
 *
 */
public class T3VMStatck {
    private List<String> list = new ArrayList<>();

    private synchronized void dontStop() {
        while (true) {
            list.add(new String("neicun"));
        }
    }

    public void statckLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        T3VMStatck t3vmStatck = new T3VMStatck();
        t3vmStatck.statckLeakByThread();
    }

}
