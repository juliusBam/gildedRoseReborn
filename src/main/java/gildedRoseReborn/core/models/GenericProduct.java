package gildedRoseReborn.core.models;

import java.util.Date;

public class GenericProduct extends BaseProduct {
    public GenericProduct(String name, double basePrice, int quality, long sellIn, Date creationDate) {
        super(name, basePrice, quality, sellIn, creationDate);
    }

    @Override
    public double calculatePrice(Date actualDate) {
        int tmpQuality = this.baseQuality;
        long tmpSellIn = this.baseSellIn;

        for (int day = 0; day < this.getAge(actualDate); day++) {
            int decreaseAmount = (tmpSellIn <= 0) ? 2 : 1; // Double decrease when past sell date
            tmpQuality = Math.max(tmpQuality - decreaseAmount, 0); // Quality cannot go below 0
            tmpSellIn--;
        }
        return tmpQuality * this.basePrice;
    }
}
