package gildedRoseReborn.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class InventoryReport {
    private String productName;
    private int quantityAvailable;

    // Constructors, Getters, and Setters
}
