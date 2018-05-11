package com.gzq.io.nio;

import java.nio.ByteBuffer;

import org.junit.Before;
import org.junit.Test;

/**
 * 练习buffer的使用。
 * buffer刻意练习的方式，深入熟悉代码。
 * @author GeYi
 *
 */
public class BufferTest {
    private  ByteBuffer allocate = null;
    
    @Before
    public void Before() {
        allocate = ByteBuffer.allocate(15);
        for(int i=0; i<10; i++) {
            allocate.put((byte)i);
        }
        
    }
    
    /**
     * 测试asReadOnlyBuffer()方法
     */
    @Test
    public void testAsReadOnlyBuffer(){
        ByteBuffer asReadOnlyBuffer = allocate.asReadOnlyBuffer();
        asReadOnlyBuffer.flip();
        while(asReadOnlyBuffer.hasRemaining()) {
            System.out.print(asReadOnlyBuffer.get() + " ");
        }
        allocate.put(1, (byte)100);
        System.out.println("");
        asReadOnlyBuffer.flip(); //allocate.flip(); 不能重置只读buffer的三个属性 
        while(asReadOnlyBuffer.hasRemaining()) {
            System.out.print(asReadOnlyBuffer.get() + " ");
        }
        try {
            asReadOnlyBuffer.put(1, (byte)100);//java.nio.ReadOnlyBufferException
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * 测试slice()方法
     */
    @Test
    public void testSlice() {
        allocate.position(3);
        allocate.limit(5);
        ByteBuffer slice = allocate.slice();
        for(int i =0; i<slice.capacity(); i++) {
            byte b = slice.get(i);
            b *= 10;
            slice.put(i, b);
        }
        
        allocate.position(0);
        allocate.limit(allocate.capacity());
        System.out.println("修改切片后buffer后员buffe的结果");
        while (allocate.hasRemaining()) {
            System.out.print(allocate.get() + " ");
        }
        
    }
    
    /**
     * 测试duplicate方法。/ˈdjuːplɪkeɪt/ 复制、复印
     * 复制后的buffer共享数据，但不共享capacity、position、limit
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

    /**
     * 测试Buffer的limit、position、capacity三个属性。
     */
    @Test
    public void testLimitPositionCapacity() {
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
