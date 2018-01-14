package com.gzq.thread.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CollectionsTest {

    public static void main(String[] args) {
        //同系列方法可以包装其它的集合类。
        Map<Object, Object> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
    }
}
