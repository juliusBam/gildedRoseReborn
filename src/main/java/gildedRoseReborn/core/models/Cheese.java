package gildedRoseReborn.core.models;

import java.util.Date;

public class Cheese extends BaseProduct {
    public Cheese(String name, double basePrice, int quality, long sellIn, Date creationDate) {
        super(name, basePrice, quality, sellIn, creationDate);
    }

    @Override
    public double calculatePrice(Date actualDate) {
        int tmpQuality = this.baseQuality;
        long tmpSellIn = this.baseSellIn;

        for (int day = 0; day < this.getAge(actualDate); day++) {
            if (tmpQuality < 50) {
                tmpQuality += 1;
                if (tmpSellIn <= 0 && tmpQuality < 50) {
                    tmpQuality += 1; // Additional increase when past sell date
                }
            }
            tmpSellIn--;
        }
        return Math.min(tmpQuality, 50) * this.basePrice;
    }
}
