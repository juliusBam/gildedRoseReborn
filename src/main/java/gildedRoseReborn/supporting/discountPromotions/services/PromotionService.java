package gildedRoseReborn.supporting.discountPromotions.services;

import gildedRoseReborn.supporting.discountPromotions.contracts.models.IDiscount;
import gildedRoseReborn.supporting.discountPromotions.models.Promotion;
import gildedRoseReborn.core.contracts.models.Priceable;

import java.util.ArrayList;
import java.util.List;

public class PromotionService {
    private List<Promotion> promotions;

    public PromotionService() {
        this.promotions = new ArrayList<>();
    }



    public List<IDiscount> getApplicablePromotions(Priceable product) {
        return promotions.stream()
                .filter(Promotion::isValid)
                .map(Promotion::getDiscount)
                .toList();
    }
}
