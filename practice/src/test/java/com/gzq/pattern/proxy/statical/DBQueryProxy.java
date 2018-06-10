package com.gzq.pattern.proxy.statical;

import java.util.List;

/**
 * 代理DBQuery的代理类
 * @author zhangxin
 *
 */
public class DBQueryProxy implements IDBQuery{
    private DBQuery dbQuery = null;

    @Override
    public List<String> get() {
        if(dbQuery == null) {
            dbQuery = new DBQuery();
        }
        List<String> list = dbQuery.get();
        return list;
    }

}
