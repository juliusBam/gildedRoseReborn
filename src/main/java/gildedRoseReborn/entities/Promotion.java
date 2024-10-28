package gildedRoseReborn.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Promotion {
    private String name;
    private String startDate; // Format: "YYYY-MM-DD"
    private String endDate; // Format: "YYYY-MM-DD"
    private Discount discount;

    public Promotion(String name, String startDate, String endDate, Discount discount) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
    }

    public boolean isValid() {
        // Simplified date check
        // In a real application, use a date library for validation
        return true; // Placeholder: Implement actual date checking logic
    }

    public Discount getDiscount() {
        return discount;
    }
}

