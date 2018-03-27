package com.gzq.pattern.proxy.v1;

public class MDBServiceImplProxy implements DBService{
    private DBService dbService;

    @Override
    public String request() {
        if(dbService == null)
            dbService = new DBServiceImpl();
        //多线程环境下，这里返回一个虚假类，类似与Future模式
        return dbService.request();
    }
    
    /**
     * 代理设计模式的基本实现方式,也叫静态代理
     * @param args
     */
    public static void main(String[] args) {
        DBService dbservice = new MDBServiceImplProxy();
        //代理模式，只有在使用的时候才加载
        String request = dbservice.request();
        System.out.println(request);
    }

}
