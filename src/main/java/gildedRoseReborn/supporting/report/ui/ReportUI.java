package gildedRoseReborn.supporting.report.ui;

import gildedRoseReborn.supporting.report.contracts.IReportUI;
import gildedRoseReborn.supporting.report.services.ReportModule;
import gildedRoseReborn.supporting.report.services.ReportService;

public class ReportUI implements IReportUI {
    private ReportService reportService;
    private ReportModule reportModule;

    public ReportUI(ReportService reportService, ReportModule reportModule) {
        this.reportService = reportService;
        this.reportModule = reportModule;
    }

    @Override
    public void generateReports() {
        System.out.println("Sales Report:");
        this.reportModule.generateSalesReport(reportService.getSalesReport());
        System.out.println();

        System.out.println("Currency Report:");
        this.reportModule.generateCurrencyReport(reportService.getCurrencyReport());
        System.out.println();

        System.out.println("Inventory Report:");
        this.reportModule.generateInventoryReport(reportService.getInventoryReports());
        System.out.println();
    }
}
