package gildedRoseReborn.supporting.discountPromotions.contracts.services;

import gildedRoseReborn.supporting.discountPromotions.contracts.models.IDiscount;

import java.util.List;

public interface IDiscountService {
    List<IDiscount> getApplicableDiscounts(int quantity);
}
