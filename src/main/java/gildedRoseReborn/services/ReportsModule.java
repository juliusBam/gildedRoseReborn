package gildedRoseReborn.services;

import gildedRoseReborn.models.CurrencyReport;
import gildedRoseReborn.models.InventoryReport;
import gildedRoseReborn.models.SaleReport;

import java.util.List;

public class ReportsModule {
    private ReportsService reportsService;

    public ReportsModule(ReportsService reportsService) {
        this.reportsService = reportsService;
    }

    public void generateSalesReport() {
        List<SaleReport> salesReports = reportsService.getSalesReport();
        salesReports.forEach(report -> {
            System.out.println("Product: " + report.getProductName() + ", Quantity Sold: " + report.getQuantitySold() + ", Total Revenue: " + report.getTotalRevenue());
        });
    }

    public void generateInventoryStatus() {
        List<InventoryReport> inventoryReports = reportsService.getInventoryStatus();
        inventoryReports.forEach(report -> {
            System.out.println("Product: " + report.getProductName() + ", Quantity Available: " + report.getQuantityAvailable());
        });
    }

    public void generateCurrencyUsage() {
        List<CurrencyReport> currencyReports = reportsService.getCurrencyUsage();
        currencyReports.forEach(report -> {
            System.out.println("Currency: " + report.getCurrencyCode() + ", Total Transactions: " + report.getTotalTransactions());
        });
    }
}
