package gildedRoseReborn.managers;

// DiscountManager.java
import gildedRoseReborn.entities.products.BaseProduct;
import gildedRoseReborn.entities.Discount;

import java.util.List;

public class DiscountManager {
    private List<Discount> discounts;

    public DiscountManager(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public List<Discount> getApplicableDiscounts(BaseProduct product, int quantity) {
        return discounts.stream()
                .filter(discount -> discount.isApplicable(quantity))
                .toList();
    }
}

