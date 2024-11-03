package gildedRoseReborn.generic.ui;

import gildedRoseReborn.core.contracts.models.Priceable;
import gildedRoseReborn.core.contracts.services.IPricingEngine;
import gildedRoseReborn.generic.cartOrder.contracts.services.ICartService;
import gildedRoseReborn.supporting.discountPromotions.contracts.services.IDiscountService;

public class CartUI {
    private ICartService cartService;
    public CartUI(ICartService cartService, IPricingEngine pricingEngine, IDiscountService discountService) {
        this.cartService = cartService;
    }

    // Method to add a product to the cart
    public void addToCart(Priceable product, int quantity) {
        cartService.addToCart(product, quantity);
    }

    // Method to remove a product from the cart
    public void removeFromCart(Priceable product, int quantity) {
        cartService.removeFromCart(product, quantity);
    }

    // Method to view the total price of the cart
    public void viewCartTotal(String currencyCode) {
        double total = cartService.calculateTotalPrice(currencyCode);
        System.out.println("Cart Total in " + currencyCode + ": " + total);
    }
}
