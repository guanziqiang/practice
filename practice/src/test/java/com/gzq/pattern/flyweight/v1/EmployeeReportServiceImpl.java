package com.gzq.pattern.flyweight.v1;

public class EmployeeReportServiceImpl implements ReportService{

    protected String company = null;
    
    public EmployeeReportServiceImpl(String company) {
        this.company = company;
    }
    
    @Override
    public String createReport() {
        return company + "公司的员工信息列表。";
    }

    @Override
    public String toString() {
        return "EmployeeReportServiceImpl [company=" + company + "]";
    }

}
