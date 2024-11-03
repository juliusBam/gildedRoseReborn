package gildedRoseReborn.core.contracts.services;

import gildedRoseReborn.core.contracts.models.Priceable;
import gildedRoseReborn.supporting.discountPromotions.contracts.models.IDiscount;

import java.util.List;

public interface IPricingEngine {
    double calculatePrice(Priceable product, List<IDiscount> IDiscounts, String currencyCode);
}
