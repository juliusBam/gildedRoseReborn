package gildedRoseReborn.engines;

// PricingEngine.java
import gildedRoseReborn.entities.products.BaseProduct;
import gildedRoseReborn.entities.Discount;
import gildedRoseReborn.services.CurrencyService;

import java.util.Date;
import java.util.List;

public class PricingEngine {
    private CurrencyService currencyService;

    public PricingEngine(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    public double calculatePrice(BaseProduct product, List<Discount> discounts, String currencyCode) {
        double finalPrice = product.calculatePrice(new Date());

        for (Discount discount : discounts) {
            finalPrice -= finalPrice * (discount.getPercentage() / 100);
        }

        // Convert to desired currency
        return currencyService.convert(finalPrice, "USD", currencyCode); // Assume USD is the base currency
    }
}

