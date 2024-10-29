package gildedRoseReborn.entities.products;

import lombok.Getter;
import lombok.Setter;

import java.time.temporal.ChronoUnit;
import java.util.Date;

@Getter
@Setter
public abstract class BaseProduct {
    protected String name;
    protected double basePrice;
    protected int baseQuality;
    protected long baseSellIn;
    protected Date creationDate;

    public BaseProduct(String name, double basePrice, int baseQuality, long baseSellIn, Date creationDate) {
        this.name = name;
        this.basePrice = basePrice;
        this.baseQuality = baseQuality;
        this.baseSellIn = baseSellIn;
        this.creationDate = creationDate;
    }

    public abstract double calculatePrice(Date actualDate);

    protected long getAge(Date actualDate) {
        return ChronoUnit.DAYS.between(this.creationDate.toInstant(), actualDate.toInstant());
    }
}
