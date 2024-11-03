package gildedRoseReborn.supporting.discountPromotions.models;

import gildedRoseReborn.supporting.discountPromotions.contracts.models.IDiscount;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Discount implements IDiscount {
    private String description;
    private double percentage; // Discount percentage
    private int minQuantity; // Minimum quantity for bulk discounts

    public Discount(String description, double percentage, int minQuantity) {
        this.description = description;
        this.percentage = percentage;
        this.minQuantity = minQuantity;
    }

    @Override
    public boolean isApplicable(int quantity) {
        return quantity >= minQuantity;
    }

    // Getters and Setters
}

