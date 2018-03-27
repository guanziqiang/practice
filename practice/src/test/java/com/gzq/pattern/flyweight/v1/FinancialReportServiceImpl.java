package com.gzq.pattern.flyweight.v1;

public class FinancialReportServiceImpl implements ReportService{

    protected String company = null;
    
    public FinancialReportServiceImpl(String company) {
        this.company = company;
    }
    
    @Override
    public String createReport() {
        return company + "公司的财务报表。";
    }

    @Override
    public String toString() {
        return "FinancialReportServiceImpl [company=" + company + "]";
    }

}
