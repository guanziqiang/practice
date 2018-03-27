package com.gzq.io.nio;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class NioServer {

    private Selector selector;
    private ExecutorService tp = Executors.newCachedThreadPool();

    public static Map<Socket, Long> time_start = new HashMap(10240);

    private void startServer() throws Exception {
        selector = SelectorProvider.provider().openSelector();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);

        InetSocketAddress isa = new InetSocketAddress(8000);
        ssc.socket().bind(isa);

        SelectionKey register = ssc.register(selector, SelectionKey.OP_ACCEPT);

        for (;;) {
            selector.select();
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> i = readyKeys.iterator();

            long e = 0;
            while (i.hasNext()) {
                SelectionKey sk = i.next();
                i.remove();

                if (sk.isAcceptable()) {
                    doAccept(sk);
                } else if (sk.isValid() && sk.isReadable()) {
                    time_start.put(((SocketChannel) sk.channel()).socket(),
                            System.currentTimeMillis());
                    doRead(sk);
                }else if(sk.isValid() && sk.isWritable()) {
                    doWrite(sk);
                    e = System.currentTimeMillis();
                    long b = time_start.remove(((SocketChannel)sk.channel()).socket());
                    System.out.println("花费时间" + (e-b));
                }

            }

        }

    }

    private void doWrite(SelectionKey sk) {
        // TODO Auto-generated method stub
        
    }

    private void doRead(SelectionKey sk) {
        SocketChannel channel  = (SocketChannel)sk.channel();
        ByteBuffer bb = ByteBuffer.allocate(8192);
        
        int len;
        
        try {
            len = channel.read(bb);
            if(len < 0) {
               disconnect(sk);
               return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("读取失败");
            disconnect(sk);
            return;
        }
        bb.flip();
        tp.execute(new HandleMessage(sk,bb));
    }

    private void disconnect(SelectionKey sk) {
        // TODO Auto-generated method stub
        
    }

    private void doAccept(SelectionKey sk) {
        ServerSocketChannel server = (ServerSocketChannel)sk.channel();
        SocketChannel clientChannel;
        try {
            clientChannel = server.accept();
            clientChannel.configureBlocking(false);
            SelectionKey register = clientChannel.register(selector, SelectionKey.OP_READ);
            
            EchoClient echoClent = new EchoClient();
            register.attach(echoClent);
            
            InetAddress inetAddress = clientChannel.socket().getInetAddress();
            
            System.out.println("接收来自："+inetAddress.getHostAddress());
            
        } catch (Exception e) {
            System.out.println("接收新的客户端失败");
            e.printStackTrace();
        }
        
    }

}
