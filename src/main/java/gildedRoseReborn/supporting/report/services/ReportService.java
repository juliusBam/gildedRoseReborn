package gildedRoseReborn.supporting.report.services;

import gildedRoseReborn.supporting.report.models.CurrencyReport;
import gildedRoseReborn.supporting.report.models.InventoryReport;
import gildedRoseReborn.supporting.report.models.SaleReport;

import java.util.List;

public class ReportService {
    // Dummy methods to simulate database interaction
    public List<SaleReport> getSalesReport() {
        return List.of(new SaleReport("Apple", 100, 200)); // Example data
    }

    public List<InventoryReport> getInventoryReports() {
        return List.of(new InventoryReport("Apple", 50)); // Example data
    }

    public List<CurrencyReport> getCurrencyReport() {
        return List.of(new CurrencyReport("USD", 1000)); // Example data
    }
}
