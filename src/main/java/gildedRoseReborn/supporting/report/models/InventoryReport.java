package gildedRoseReborn.supporting.report.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InventoryReport {
    private String productName;
    private int quantityAvailable;

    // Constructors, Getters, and Setters
}
