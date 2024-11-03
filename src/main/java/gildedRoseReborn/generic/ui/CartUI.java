package gildedRoseReborn.generic.ui;

import gildedRoseReborn.core.contracts.models.Priceable;
import gildedRoseReborn.core.contracts.services.IPricingEngine;
import gildedRoseReborn.generic.cartOrder.contracts.services.ICartService;
import gildedRoseReborn.supporting.discountPromotions.contracts.services.IDiscountService;

public class CartUI {
    private ICartService cartService;
    private IPricingEngine pricingEngine;
    private IDiscountService discountService;
    public CartUI(ICartService cartService, IPricingEngine pricingEngine, IDiscountService discountService) {
        this.cartService = cartService;
        this.pricingEngine = pricingEngine;
        this.discountService = discountService;
    }

    // Method to add a product to the cart
    public void addToCart(Priceable product, int quantity) {
        cartService.addToCart(product, quantity);
        System.out.println(quantity + " " + product.getName() + "(s) added to the cart.");
    }

    // Method to remove a product from the cart
    public void removeFromCart(Priceable product, int quantity) {
        cartService.removeFromCart(product, quantity);
        System.out.println(quantity + " " + product.getName() + "(s) removed from the cart.");
    }

    // Method to view the total price of the cart
    public void viewCartTotal(String currencyCode) {
        double total = cartService.calculateTotalPrice(pricingEngine, discountService, currencyCode);
        System.out.println("Cart Total in " + currencyCode + ": " + total);
    }
}
