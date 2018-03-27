package com.gzq.io.nio;

import java.nio.ByteBuffer;

import org.junit.Test;

public class BufferTest {
    
    /**
     * 测试/ˈdjuːplɪkeɪt/ 复制、复印duplicate方法。
     */
    @Test
    public void testDuplicate() {
        ByteBuffer allocate = ByteBuffer.allocate(15);
        for(int i=0; i<10; i++) {
            allocate.put((byte)i);
        }
        
        ByteBuffer duplicate = allocate.duplicate();
        System.out.println("使用duplicate方法后--------");
        System.out.println(allocate);
        System.out.println(duplicate);
        
        duplicate.flip();
        System.out.println("将复制的buffer使用flip后--------");
        System.out.println(allocate);
        System.out.println(duplicate);

        duplicate.put((byte) 99);
        System.out.println("改变复制后buffer的数据--------");
        System.out.println(allocate);
        System.out.println(duplicate);
        System.out.println(allocate.get(0));
        System.out.println(duplicate.get(0));
        
        
        
    }

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(15);
        
        System.out.println("position  limit  capacity");
        System.out.println(buffer.position()+"    :    "+ buffer.limit() 
            + "    :    "+ buffer.capacity());
        for(int i=0; i<10; i++) {
            buffer.put((byte)i);
        }
        System.out.println("position  limit  capacity");
        System.out.println(buffer.position()+"    :    "+ buffer.limit() 
        + "    :    "+ buffer.capacity());
        
        buffer.flip();
        
        System.out.println("position  limit  capacity");
        System.out.println(buffer.position()+"    :    "+ buffer.limit() 
        + "    :    "+ buffer.capacity());
        
        for(int i=0; i<5; i++) {
            buffer.put((byte)i);
        }
        
        System.out.println("position  limit  capacity");
        System.out.println(buffer.position()+"    :    "+ buffer.limit() 
        + "    :    "+ buffer.capacity());
        
    }
    
}
