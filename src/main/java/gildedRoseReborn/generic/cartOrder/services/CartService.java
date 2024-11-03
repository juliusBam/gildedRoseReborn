package gildedRoseReborn.generic.cartOrder.services;

import gildedRoseReborn.core.contracts.services.IPricingEngine;
import gildedRoseReborn.core.contracts.services.IProductService;
import gildedRoseReborn.core.contracts.models.Priceable;

import gildedRoseReborn.generic.cartOrder.contracts.services.ICartService;
import gildedRoseReborn.generic.cartOrder.contracts.services.IOrderService;
import gildedRoseReborn.supporting.discountPromotions.contracts.models.IDiscount;
import gildedRoseReborn.supporting.discountPromotions.contracts.services.IDiscountService;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Getter
@Setter
public class CartService implements ICartService {
    private Map<Priceable, Integer> cartItems = new HashMap<>();
    private IProductService productService;  // Use IProductService interface
    private IOrderService orderService;
    private IPricingEngine pricingEngine;
    private IDiscountService discountService;

    // Constructor to inject IProductService
    public CartService(IProductService productService, IOrderService orderService, IPricingEngine pricingEngine, IDiscountService discountService) {
        this.productService = productService;
        this.orderService = orderService;
        this.pricingEngine = pricingEngine;
        this.discountService = discountService;
    }

    // Add a product to the cart with the specified quantity, checking stock availability
    public void addToCart(Priceable product, int quantity) {
        int availableQuantity = productService.getProductQuantity(product);  // Check quantity in stock
        int currentCartQuantity = cartItems.getOrDefault(product, 0);

        if (availableQuantity >= currentCartQuantity + quantity) {
            cartItems.put(product, currentCartQuantity + quantity);
            System.out.println(quantity + " units of " + product.getName() + " added to the cart.");
        } else {
            System.out.println("Insufficient stock for " + product.getName() + ". Available: " + availableQuantity);
        }
    }

    // Remove a specified quantity of a product from the cart
    public void removeFromCart(Priceable product, int quantity) {
        if (cartItems.containsKey(product)) {
            int currentQuantity = cartItems.get(product);
            int newQuantity = currentQuantity - quantity;

            if (newQuantity > 0) {
                cartItems.put(product, newQuantity);
            } else {
                cartItems.remove(product);  // Remove product entirely if quantity is zero or less
            }
        }
    }

    // Clears all items from the cart
    public void clearCart() {
        cartItems.clear();
    }

    // Calculate total price of all items in the cart, considering discounts and pricing rules
    public double calculateTotalPrice(String currency) {
        double total = 0;
        for (Map.Entry<Priceable, Integer> entry : cartItems.entrySet()) {
            Priceable product = entry.getKey();
            int quantity = entry.getValue();
            List<IDiscount> IDiscounts = this.discountService.getApplicableDiscounts(quantity);

            double itemTotal = this.pricingEngine.calculatePrice(product, IDiscounts, currency) * quantity;
            total += itemTotal;
        }
        return total;
    }

    public void buyProducts(String currencyCode) {
        if (this.cartItems.size() == 0) {
            System.out.println("Cart empty");
            return;
        }

        this.orderService.processOrder(this.cartItems, this.calculateTotalPrice(currencyCode), currencyCode);
        this.clearCart();
    }

    // Retrieve the items in the cart
    @Override
    public Map<Priceable, Integer> getCartItems() {
        return new HashMap<>(cartItems);
    }
}
