package com.gzq.io.nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

import org.junit.Test;

import com.gzq.practice.utils.BitUtil;

public class FileChannelTest {

    /**
     * 比较io与nio、nio映射内存三种读写文件的性能差别
     * 
     * @throws IOException
     */
    @Test
    public void testIoVSNio() throws IOException {
        int number = 8000000;// 文件越大，nio效果越好

        // 以io形式写入文件
        long begin = System.currentTimeMillis();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream(new File("d:\\iofile.txt"))));
        for (int i = 0; i < number; i++) {
            dos.writeInt(i);
        }
        if (null != dos) {
            dos.flush();
            dos.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("io写入文件的时间" + (end - begin));

        // 以io形式读入文件
        begin = System.currentTimeMillis();
        DataInputStream dis = new DataInputStream(new BufferedInputStream(
                new FileInputStream(new File("d:\\iofile.txt"))));
        for (int i = 0; i < number; i++) {
            dis.readInt();
        }
        if (null != dis) {
            dis.close();
        }
        end = System.currentTimeMillis();
        System.out.println("io读入文件的时间" + (end - begin));

        // 以nio形式写入文件
        begin = System.currentTimeMillis();
        FileOutputStream fos = new FileOutputStream(new File("d:\\niofile.txt"));
        FileChannel channel = fos.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(number * 4);
        for (int i = 0; i < number; i++) {
            allocate.put(BitUtil.intToBytes(i));
        }
        allocate.flip();
        channel.write(allocate);
        fos.close();
        end = System.currentTimeMillis();
        System.out.println("nio写入文件的时间" + (end - begin));

        // 以nio形式读入文件
        begin = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream(new File("d:\\niofile.txt"));
        FileChannel channel2 = fis.getChannel();
        ByteBuffer allocate2 = ByteBuffer.allocate(number * 4);
        channel2.read(allocate2);
        channel2.close();
        allocate2.flip();
        while (allocate.hasRemaining()) {
            BitUtil.bytesToInt(allocate2.get(), allocate2.get(), allocate2.get(),
                    allocate2.get());
        }
        fis.close();
        end = System.currentTimeMillis();
        System.out.println("nio读入文件的时间" + (end - begin));

        // 以nio映射内存形式写入文件
        begin = System.currentTimeMillis();
        FileChannel channel3 = new RandomAccessFile(new File("d:\\nioMfile.txt"), "rw")
                .getChannel();
        IntBuffer asIntBuffer = channel3.map(MapMode.READ_WRITE, 0, number * 4)
                .asIntBuffer();
        for (int i = 0; i < number; i++) {
            asIntBuffer.put(i);
        }
        channel3.close();
        end = System.currentTimeMillis();
        System.out.println("nio内存形式写入文件的时间 " + (end - begin));

        // 以nio映射内存形式写入文件
        begin = System.currentTimeMillis();
//        FileChannel fc = new RandomAccessFile(new File("d:\\nioMfile.txt"),"rw").getChannel();
        FileChannel fc = new FileInputStream(new File("d:\\nioMfile.txt")).getChannel();
        IntBuffer asIntBuffer2 = fc.map(MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
        while(asIntBuffer2.hasRemaining()) {
            asIntBuffer2.get();
        }
        fc.close();
        end = System.currentTimeMillis();
        System.out.println("nio内存形式读入文件的时间 " + (end - begin));

    }

    /**
     * 测试结构化数据：聚集写文件、散射读文件
     */
    @Test
    public void testReadWrite() {
        try {
            ByteBuffer bookBuf = ByteBuffer.wrap("Java NIO编程".getBytes("utf-8"));
            ByteBuffer autBuf = ByteBuffer.wrap("知行合一".getBytes("utf-8"));
            int bookLen = bookBuf.limit();
            int autLen = autBuf.limit();

            ByteBuffer[] bufs = new ByteBuffer[] { bookBuf, autBuf };

            File file = new File("d:\\jiegou.txt");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    FileOutputStream fos = new FileOutputStream(file);
                    FileChannel channel = fos.getChannel();

                    channel.write(bufs); // 聚集写文件
                    fos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                FileInputStream fis = new FileInputStream(file);
                FileChannel channel = fis.getChannel();
                ByteBuffer buf1 = ByteBuffer.allocate(bookLen);
                ByteBuffer buf2 = ByteBuffer.allocate(autLen);
                ByteBuffer[] bufs2 = new ByteBuffer[] { buf1, buf2 };
                channel.read(bufs2);// 散射读文件
                String book = new String(bufs2[0].array(), "utf8");
                String aut = new String(bufs2[1].array(), "utf8");
                System.out.println(book + aut);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件映射到内存
     * 
     * @throws IOException
     */
    @Test
    public void testMap() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\gzqt\\test.txt",
                "rw");
        FileChannel channel = randomAccessFile.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0,
                randomAccessFile.length());
        while (map.hasRemaining()) {
            System.out.println(map.get());
        }
        map.put(3, (byte) 'a');
        randomAccessFile.close();
        System.out.println((byte) 'a');
        System.out
                .println(new String(new byte[] { map.get(4), map.get(5), map.get(6) }));
    }

    /**
     * 使用FileChannel复制文本
     * 
     * @param args
     * @throws IOException
     */
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
                if (read == -1) {
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
