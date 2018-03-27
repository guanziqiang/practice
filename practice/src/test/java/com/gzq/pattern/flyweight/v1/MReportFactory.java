package com.gzq.pattern.flyweight.v1;

import java.util.HashMap;
import java.util.Map;

public class MReportFactory {
    Map<String, ReportService> employees = new HashMap<>();
    Map<String, ReportService> financials = new HashMap<>();

    public synchronized ReportService getEmployee(String company) {
        ReportService reportService = employees.get(company);
        if (reportService == null) {
            reportService = new EmployeeReportServiceImpl(company);
            employees.put(company, reportService);
        }
        return reportService;
    }
    
    public synchronized ReportService getFinancial(String company) {
        ReportService reportService = financials.get(company);
        if (reportService == null) {
            reportService = new EmployeeReportServiceImpl(company);
            financials.put(company, reportService);
        }
        return reportService;
    }
    
    /**
     * 享元模式
     * @param args
     */
    public static void main(String[] args) {
       MReportFactory mReportFactory = new MReportFactory();
       ReportService employee = mReportFactory.getEmployee("gzq");
       System.out.println(employee.createReport());
       ReportService financial = mReportFactory.getFinancial("mind");
       System.out.println(financial.createReport());
    }
    
}
