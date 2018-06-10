package com.gzq.pattern.proxy.cglib;

import java.util.List;

/**
 * 代理对象接口
 * @author zhangxin
 *
 */
public interface IDBQuery {
    
    public List<String> get();
    
    public String list(String name);

}
