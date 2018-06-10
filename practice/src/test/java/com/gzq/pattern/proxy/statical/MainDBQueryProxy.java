package com.gzq.pattern.proxy.statical;

import java.util.List;

/**
 * 测试静态代理，实现延时加载的演示案例。
 * @author zhangxin
 *
 */
public class MainDBQueryProxy {
    public static void main(String[] args) {
        IDBQuery query = new DBQueryProxy();
        //延时加载，在确定被调用时加载
        List<String> list = query.get();
        System.out.println(list);
    }
}
