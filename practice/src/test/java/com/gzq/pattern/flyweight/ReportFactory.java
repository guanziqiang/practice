package com.gzq.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂，可以作为多个享元对象的工厂。
 * @author zhangxin
 *
 */
public class ReportFactory {
    Map<String, ReportService> employees = new HashMap<>();
    Map<String, ReportService> financials = new HashMap<>();

    /**
     * 维护员工信息列表的享元模式
     * @param company
     * @return
     */
    public synchronized ReportService getEmployee(String company) {
        ReportService reportService = employees.get(company);
        if (reportService == null) {
            reportService = new EmployeeReportServiceImpl(company);
            employees.put(company, reportService);
        }
        return reportService;
    }
    
    /**
     * 维护财务信息列表的享元模式
     * @param company
     * @return
     */
    public synchronized ReportService getFinancial(String company) {
        ReportService reportService = financials.get(company);
        if (reportService == null) {
            reportService = new FinancialReportServiceImpl(company);
            financials.put(company, reportService);
        }
        return reportService;
    }
    
}
