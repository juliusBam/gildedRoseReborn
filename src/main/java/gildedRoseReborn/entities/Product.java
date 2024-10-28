package gildedRoseReborn.entities;

public class Product extends BaseProduct {
    public Product(String name, double basePrice, String category) {
        super(name, basePrice, category);
    }

    @Override
    public double calculatePrice() {
        // Add logic to incorporate quality adjustments
        return getBasePrice() * getQuality();
    }
}