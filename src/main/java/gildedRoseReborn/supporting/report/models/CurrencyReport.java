package gildedRoseReborn.supporting.report.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrencyReport {
    private String currencyCode;
    private double totalTransactions;

    // Constructors, Getters, and Setters
}
