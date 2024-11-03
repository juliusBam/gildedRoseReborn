package gildedRoseReborn.supporting.report.services;

import gildedRoseReborn.supporting.report.models.CurrencyReport;
import gildedRoseReborn.supporting.report.models.InventoryReport;
import gildedRoseReborn.supporting.report.models.SaleReport;

import java.util.List;

public class ReportModule {
    private ReportService reportService;

    public ReportModule(ReportService reportService) {
        this.reportService = reportService;
    }

    public void generateSalesReport() {
        List<SaleReport> salesReports = reportService.getSalesReport();
        salesReports.forEach(report -> {
            System.out.println("Product: " + report.getProductName() + ", Quantity Sold: " + report.getQuantitySold() + ", Total Revenue: " + report.getTotalRevenue());
        });
    }

    public void generateInventoryStatus() {
        List<InventoryReport> inventoryReports = reportService.getInventoryStatus();
        inventoryReports.forEach(report -> {
            System.out.println("Product: " + report.getProductName() + ", Quantity Available: " + report.getQuantityAvailable());
        });
    }

    public void generateCurrencyUsage() {
        List<CurrencyReport> currencyReports = reportService.getCurrencyUsage();
        currencyReports.forEach(report -> {
            System.out.println("Currency: " + report.getCurrencyCode() + ", Total Transactions: " + report.getTotalTransactions());
        });
    }
}
