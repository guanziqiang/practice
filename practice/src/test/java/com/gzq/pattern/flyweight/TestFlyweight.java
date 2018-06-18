package com.gzq.pattern.flyweight;

/**
 * 享元模式,测试入口
 * @author zhangxin
 *
 */
public class TestFlyweight {
    
    public static void main(String[] args) {
       ReportFactory mReportFactory = new ReportFactory();
       
       ReportService employee1_1 = mReportFactory.getEmployee("CompanyOne");
       System.out.println(employee1_1.createReport());
       ReportService employee1_2 = mReportFactory.getEmployee("CompanyOne");
       System.out.println(employee1_2.createReport());
       System.out.println(employee1_1 == employee1_2);//享元模式，同一个公司的员工信息表是共享的一个对象。
       
       System.out.println("=================================");
       ReportService employee2 = mReportFactory.getEmployee("CompanyTwo");
       System.out.println(employee2.createReport());
       
       System.out.println("=================================");
       ReportService financial = mReportFactory.getFinancial("mind");
       System.out.println(financial.createReport());
    }

}
