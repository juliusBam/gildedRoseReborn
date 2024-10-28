package gildedRoseReborn.services;

import gildedRoseReborn.models.CurrencyReport;
import gildedRoseReborn.models.InventoryReport;
import gildedRoseReborn.models.SaleReport;

import java.util.List;

public class ReportsService {
    // Dummy methods to simulate database interaction
    public List<SaleReport> getSalesReport() {
        return List.of(new SaleReport("Apple", 100, 200)); // Example data
    }

    public List<InventoryReport> getInventoryStatus() {
        return List.of(new InventoryReport("Apple", 50)); // Example data
    }

    public List<CurrencyReport> getCurrencyUsage() {
        return List.of(new CurrencyReport("USD", 1000)); // Example data
    }
}
