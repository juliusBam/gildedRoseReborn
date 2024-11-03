package gildedRoseReborn.supporting.discountPromotions.contracts.models;

public interface IDiscount {
    boolean isApplicable(int quantity);

    String getDescription();

    double getPercentage();

    int getMinQuantity();
}
