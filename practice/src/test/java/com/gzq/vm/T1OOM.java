package com.gzq.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试让Java的heap内存抛出java.lang.OutOfMemoryError异常
 * 设置调试运行时VM的参数 -Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
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
