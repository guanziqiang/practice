package com.gzq.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    
    public static void main(String[] args) throws IOException {
        try {
            FileInputStream fis = new FileInputStream("D:\\gzqt\\test.txt");
            FileChannel channel = fis.getChannel();
            
            FileOutputStream fos = new FileOutputStream("D:\\gzqt\\test2.txt");
            FileChannel channel2 = fos.getChannel();
            
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            
            while (true) {
                buffer.clear();
                int read = channel.read(buffer);
                if(read == -1) {
                    break;
                }
                buffer.flip();
                channel2.write(buffer);
            }
            
            channel.close();
            channel2.close();
            
            
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }
}
