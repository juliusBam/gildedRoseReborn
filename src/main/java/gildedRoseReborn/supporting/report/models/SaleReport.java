package gildedRoseReborn.supporting.report.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaleReport {
    private String productName;
    private int quantitySold;
    private double totalRevenue;
}

