package com.gzq.io.nio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import org.junit.Test;

/**
 * 测试SocketChannel和ServerSocketChannel的使用。
 * 
 * @author GeYi
 *
 */
public class SocketChannelServerM {

    /**
     * ServerSocketChannel构建的服务端，与{@code com.gzq.io.nio.SocketChannelServerM}配合测试。
     */
    public static void main(String[] args) {
        ServerSocketChannel server = null;
        try {
            server = ServerSocketChannel.open();
            server.bind(new InetSocketAddress(1234));
            server.configureBlocking(false);
            while (true) {
                SocketChannel socketChannel = server.accept();
                if (socketChannel != null) {
                    
                    new Thread() {
                        @Override
                        public void run() {
                            ByteBuffer readBuf = ByteBuffer.allocate(1024);
                            int read = 0;
                            System.out.println(socketChannel);
                            try {
                                readBuf.clear();
                                read = socketChannel.read(readBuf);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println("It's reading: "+read);
                            if (read != -1) {
                                readBuf.flip();
                                System.out.println(readBuf);
                                try {
                                    System.out.println(new String(readBuf.array(), "utf-8"));
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                            }
                          
                        };
                    }.start();
                    
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
