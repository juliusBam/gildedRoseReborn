package gildedRoseReborn.generic.cartOrder.contracts.services;

import gildedRoseReborn.core.contracts.models.Priceable;
import gildedRoseReborn.core.contracts.services.IPricingEngine;
import gildedRoseReborn.supporting.discountPromotions.contracts.services.IDiscountService;

import java.util.Map;

public interface ICartService {
    // Add a product to the cart with the specified quantity
    void addToCart(Priceable product, int quantity);

    // Remove a specified quantity of a product from the cart, or remove completely if quantity is zero or less
    void removeFromCart(Priceable product, int quantity);

    // Clears all items from the cart
    void clearCart();

    // Calculate total price of all items in the cart, considering discounts and pricing rules
    double calculateTotalPrice(IPricingEngine IPricingEngine, IDiscountService IDiscountService, String currency);

    // Retrieve the items in the cart
    Map<Priceable, Integer> getCartItems();

    void setCartItems(Map<Priceable, Integer> cartItems);
}
