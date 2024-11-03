package gildedRoseReborn.supporting.discountPromotions.services;

// DiscountManager.java
import gildedRoseReborn.supporting.discountPromotions.contracts.models.IDiscount;
import gildedRoseReborn.supporting.discountPromotions.contracts.services.IDiscountService;

import java.util.List;

public class DiscountService implements IDiscountService {
    private List<IDiscount> IDiscounts;
    private PromotionService promotionService;

    public DiscountService(List<IDiscount> IDiscounts, PromotionService promotionService) {
        this.IDiscounts = IDiscounts;
        this.promotionService = promotionService;
    }

    @Override
    public List<IDiscount> getApplicableDiscounts(int quantity) {
        return IDiscounts.stream()
                .filter(discount -> discount.isApplicable(quantity))
                .toList();
    }
}

