package gildedRoseReborn.generic.ui;

import gildedRoseReborn.supporting.report.services.ReportService;

public class ReportUI {
    private ReportService reportService;

    public ReportUI(ReportService reportService) {
        this.reportService = reportService;
    }

    public void generateReports() {
        reportService.getSalesReport();
    }
}
