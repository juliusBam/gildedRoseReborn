package gildedRoseReborn.services;
import gildedRoseReborn.engines.PricingEngine;
import gildedRoseReborn.entities.Discount;
import gildedRoseReborn.entities.products.BaseProduct;
import gildedRoseReborn.managers.DiscountManager;
import lombok.Getter;
import lombok.Setter;


import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Getter
@Setter
public class CartService {
    private Map<BaseProduct, Integer> cartItems = new HashMap<>();

    // Add a product to the cart with the specified quantity
    public void addToCart(BaseProduct product, int quantity) {
        cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
    }

    // Remove a specified quantity of a product from the cart, or remove completely if quantity is zero or less
    public void removeFromCart(BaseProduct product, int quantity) {
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
    public double calculateTotalPrice(PricingEngine pricingEngine, DiscountManager discountManager, String currency) {
        double total = 0;
        for (Map.Entry<BaseProduct, Integer> entry : cartItems.entrySet()) {
            BaseProduct product = entry.getKey();
            int quantity = entry.getValue();
            List<Discount> discounts = discountManager.getApplicableDiscounts(quantity);

            double itemTotal = pricingEngine.calculatePrice(product, discounts, currency) * quantity;
            total += itemTotal;
        }
        return total;
    }

    // Retrieve the items in the cart
    public Map<BaseProduct, Integer> getCartItems() {
        return new HashMap<>(cartItems);
    }
}
