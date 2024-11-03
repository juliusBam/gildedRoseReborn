package gildedRoseReborn.core.contracts.models;

import java.util.Date;

public interface Priceable {
    double calculatePrice(Date actualDate);

    String getName();

    int getBaseQuality();
}
