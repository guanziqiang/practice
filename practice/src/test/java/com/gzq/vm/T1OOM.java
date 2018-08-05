package com.gzq.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试让Java的heap内存抛出java.lang.OutOfMemoryError异常
 * 设置调试运行时VM的参数 -Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
Xms 和 Xmx指定的是Java堆的内存空间
Xms 是指设定程序启动时占用内存大小。一般来讲，大点，程序会启动的快一点，但是也可能会导致机器暂时间变慢。
Xmx 是指设定程序运行期间最大可占用的内存大小。如果程序运行需要占用更多的内存，超出了这个设置值，就会抛出OutOfMemory异常。
-XX:+HeapDumpOnOutOfMemoryError可以让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照以便事后进行分析。
 * @author escore
 *
 */
public class T1OOM {
    public static void main(String[] args) {
        List<T1OOM> list = new ArrayList<>();
        while(true) {
            list.add(new T1OOM());
        }
    }
}
