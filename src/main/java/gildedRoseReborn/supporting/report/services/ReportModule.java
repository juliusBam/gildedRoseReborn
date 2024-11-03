package gildedRoseReborn.supporting.report.services;

import gildedRoseReborn.supporting.report.models.CurrencyReport;
import gildedRoseReborn.supporting.report.models.InventoryReport;
import gildedRoseReborn.supporting.report.models.SaleReport;

import java.util.List;

public class ReportModule {

    public ReportModule() {

    }

    public void generateSalesReport(List<SaleReport> salesReports) {
        salesReports.forEach(report -> {
            System.out.println("Product: " + report.getProductName() + ", Quantity Sold: " + report.getQuantitySold() + ", Total Revenue: " + report.getTotalRevenue());
        });
    }

    public void generateInventoryReport(List<InventoryReport> inventoryReports) {
        inventoryReports.forEach(report -> {
            System.out.println("Product: " + report.getProductName() + ", Quantity Available: " + report.getQuantityAvailable());
        });
    }

    public void generateCurrencyReport(List<CurrencyReport> currencyReports) {
        currencyReports.forEach(report -> {
            System.out.println("Currency: " + report.getCurrencyCode() + ", Total Transactions: " + report.getTotalTransactions());
        });
    }
}
