package gildedRoseReborn.core.models;

import java.util.Date;

public class LegendaryItem extends BaseProduct {
    public LegendaryItem(String name, double basePrice, int quality, long sellIn, Date creationDate) {
        super(name, basePrice, quality, sellIn, creationDate);
    }

    //Legendary item does not change quality, always returns the same quality
    @Override
    public double calculatePrice(Date actualDate) {
        // Add logic to incorporate quality adjustments
        return this.basePrice * this.baseQuality;
    }
}