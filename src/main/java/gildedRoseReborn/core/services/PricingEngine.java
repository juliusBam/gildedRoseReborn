package gildedRoseReborn.core.services;

// PricingEngine.java
import gildedRoseReborn.core.contracts.models.Priceable;
import gildedRoseReborn.supporting.currency.contracts.ICurrencyService;
import gildedRoseReborn.supporting.discountPromotions.contracts.models.IDiscount;

import java.util.Date;
import java.util.List;

public class PricingEngine implements gildedRoseReborn.core.contracts.services.IPricingEngine {
    private ICurrencyService currencyService;

    public PricingEngine(ICurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Override
    public double calculatePrice(Priceable product, List<IDiscount> IDiscounts, String currencyCode) {
        double finalPrice = product.calculatePrice(new Date());

        for (IDiscount IDiscount : IDiscounts) {
            finalPrice -= finalPrice * (IDiscount.getPercentage() / 100);
        }

        // Convert to desired currency
        return currencyService.convert(finalPrice, "USD", currencyCode); // Assume USD is the base currency
    }
}

