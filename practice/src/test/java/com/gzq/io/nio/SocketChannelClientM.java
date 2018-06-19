package com.gzq.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 测试SocketChannel和ServerSocketChannel的使用。
 * @author GeYi
 *
 */
public class SocketChannelClientM {
    
    /**
     * 构建一个SocketChannel客户端，与{@code com.gzq.io.nio.SocketChannelClientM}配合测试。
     */
    public static void main(String[] args) {
        SocketChannel clientChannel = null;
        try {
            //客户端建立与服务器的连接
            clientChannel = SocketChannel.open();
            //clientChannel.socket().bind(new InetSocketAddress("127.0.0.1", 8088));
//            clientChannel.configureBlocking(false);
            clientChannel.connect(new InetSocketAddress(1234));
            while( !clientChannel.isConnected() ) {
                //客户端正在连接服务器，再次之前可以做的其他事情。
                System.out.println(clientChannel);
            }
            
            //客户端准备写入的Buffer，并写入到通道。
            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
            writeBuffer.put("this is SocketChannel clientChannel".getBytes());
            writeBuffer.flip();
            System.out.println(clientChannel);
            System.out.println(writeBuffer);
            while (writeBuffer.hasRemaining()) {
                clientChannel.write(writeBuffer);
            }
            System.out.println("客户端数据已经发送完毕");
            
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(clientChannel != null) {
                try {
                    clientChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    

}
