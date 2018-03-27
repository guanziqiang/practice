package com.gzq.io.nio;

import java.util.LinkedList;

import java.nio.ByteBuffer;

public class EchoClient {
    private LinkedList<ByteBuffer> outq;
    
    public EchoClient() {
        outq = new LinkedList<>();
    }
    
    public LinkedList<ByteBuffer> getOutputQueue(){
        return outq;
    }
    
    public void enqueue(ByteBuffer bb) {
        outq.add(bb);
    }
    
}

