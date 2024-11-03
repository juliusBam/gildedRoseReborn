package gildedRoseReborn.core.models;

import java.util.Date;

public class BackstagePass extends BaseProduct {
    public BackstagePass(String name, double basePrice, int quality, long sellIn, Date creationDate) {
        super(name, basePrice, quality, sellIn, creationDate);
    }

    @Override
    public double calculatePrice(Date actualDate) {

        int tmpQuality = this.baseQuality;
        long tmpSellIn = this.baseSellIn;

        for (long day = 0; day < this.getAge(actualDate); day++) {
            if (tmpSellIn < 0) {
                tmpQuality = 0; // Expired passes lose all quality
                break;
            } else if (tmpSellIn < 6) {
                tmpQuality = Math.min(tmpQuality + 3, 50); // Triple increase within 5 days of the event
            } else if (tmpSellIn < 11) {
                tmpQuality = Math.min(tmpQuality + 2, 50); // Double increase within 10 days of the event
            } else {
                tmpQuality = Math.min(tmpQuality + 1, 50); // Normal increase otherwise
            }
            tmpSellIn--;
        }
        return tmpQuality * this.basePrice;
    }
}
