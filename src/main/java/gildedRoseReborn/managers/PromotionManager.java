package gildedRoseReborn.managers;

import gildedRoseReborn.entities.products.BaseProduct;
import gildedRoseReborn.entities.Discount;
import gildedRoseReborn.entities.Promotion;

import java.util.List;

public class PromotionManager {
    private List<Promotion> promotions;

    public PromotionManager(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public List<Discount> getApplicablePromotions(BaseProduct product) {
        return promotions.stream()
                .filter(Promotion::isValid)
                .map(Promotion::getDiscount)
                .toList();
    }
}
