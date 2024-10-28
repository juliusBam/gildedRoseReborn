package gildedRoseReborn.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseProduct {
    private String name;
    private double basePrice;
    private String category;
    private double quality; // Quality value between 0 and 1

    public BaseProduct(String name, double basePrice, String category) {
        this.name = name;
        this.basePrice = basePrice;
        this.category = category;
        this.quality = 1.0; // Default quality
    }

    // Common methods
    public abstract double calculatePrice();

}
