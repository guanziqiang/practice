package com.gzq.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xoos设置本地方法栈大小，但在hotspot虚拟机中不区分虚拟机栈和本地方法栈，因此改参数是无效的。
 * -Xss 设置虚拟机栈大小。
 * @author Administrator
 *
 */
public class T2VMStack {
    private int stackLength = 1;
    private List<String> list = new ArrayList<>();
    
    public void stackLeak() {
        stackLength++;
        stackLeak();
        /*
         *   运行下面代码抛出GC overhead limit exceeded异常 
         */
//        while(true) {
//            list.add(new String("neicun"));
//        }
    }
    
    public static void main(String[] args) {
        T2VMStack t2vmStack = new T2VMStack();
        System.out.println("虚拟机栈深度" + t2vmStack.stackLength);
        try {
            t2vmStack.stackLeak();
        } catch (Throwable e) {
            System.out.println("虚拟机栈深度" + t2vmStack.stackLength);
            e.printStackTrace();
        }
    }

}
