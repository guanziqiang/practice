package com.gzq;

import java.util.concurrent.LinkedBlockingQueue;

public class MainTest {
    
    public static void main(String[] args) {
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>();
        boolean offer = linkedBlockingQueue.offer("node1");
        String poll1 = linkedBlockingQueue.poll();
        System.out.println(poll1);
        String poll2 = linkedBlockingQueue.poll();
        System.out.println(poll2);
    }
    

}
