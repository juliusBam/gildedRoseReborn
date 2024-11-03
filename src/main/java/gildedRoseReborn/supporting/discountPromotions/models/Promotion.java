package gildedRoseReborn.supporting.discountPromotions.models;

import gildedRoseReborn.supporting.discountPromotions.contracts.models.IDiscount;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Promotion {
    private String name;
    private String startDate; // Format: "YYYY-MM-DD"
    private String endDate; // Format: "YYYY-MM-DD"
    private gildedRoseReborn.supporting.discountPromotions.contracts.models.IDiscount IDiscount;

    public Promotion(String name, String startDate, String endDate, IDiscount IDiscount) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.IDiscount = IDiscount;
    }

    public boolean isValid() {
        // Simplified date check
        // In a real application, use a date library for validation
        return true; // Placeholder: Implement actual date checking logic
    }

    public IDiscount getDiscount() {
        return IDiscount;
    }
}

