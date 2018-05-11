package com.gzq.io.nio.netcase1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class SocketChanneClient {
    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(1234));
        while( !socketChannel.isConnected() ) {
            //客户端正在连接服务器，再次之前可以做的其他事情。
            System.out.println(socketChannel);
        }
        System.out.println(socketChannel);
        
        while (true) {
            Scanner sc = new Scanner(System.in);
            String next = sc.next();
            sendMessage(socketChannel, next);
        }
    }

    public static void sendMessage(SocketChannel socketChannel, String mes)
            throws IOException {
        if (mes == null || mes.isEmpty()) {
            return;
        }
        byte[] bytes = mes.getBytes("UTF-8");
        int size = bytes.length;
        ByteBuffer buffer = ByteBuffer.allocate(size);
        ByteBuffer sizeBuffer = ByteBuffer.allocate(4);

        sizeBuffer.putInt(size);
        buffer.put(bytes);

        buffer.flip();
        sizeBuffer.flip();
        ByteBuffer dest[] = { sizeBuffer, buffer };
        while (sizeBuffer.hasRemaining() || buffer.hasRemaining()) {
            socketChannel.write(dest);
        }
    }
}
