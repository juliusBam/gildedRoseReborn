package gildedRoseReborn.generic.cartOrder.services;

// OrderService.java
import gildedRoseReborn.core.contracts.services.IProductService;
import gildedRoseReborn.core.services.PricingEngine;
import gildedRoseReborn.generic.cartOrder.contracts.models.IOrder;
import gildedRoseReborn.generic.cartOrder.contracts.services.IOrderService;
import gildedRoseReborn.generic.cartOrder.entities.Order;
import gildedRoseReborn.core.contracts.models.Priceable;
import gildedRoseReborn.supporting.currency.CurrencyService;
import gildedRoseReborn.supporting.discountPromotions.services.DiscountService;
import gildedRoseReborn.supporting.discountPromotions.services.PromotionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderService implements IOrderService {

    private List<IOrder> orders = new ArrayList<>();
    private IProductService productService;  // Use IProductService interface

    // Constructor to inject IProductService
    public OrderService(IProductService productService) {
        this.productService = productService;
    }

    public void processOrder(Map<Priceable, Integer> cartItems, double totalPrice, String currencyCode) {
        // Check if enough products are available
        boolean canFulfillOrder = true;
        for (var entry : cartItems.entrySet()) {
            int cartQuantity = entry.getValue();
            int availableQuantity = productService.getProductQuantity(entry.getKey());
            if (availableQuantity < cartQuantity) {
                System.out.println("Insufficient stock for " + entry.getKey().getName() + ". Available: " + availableQuantity + ", Requested: " + cartQuantity);
                canFulfillOrder = false;
            }
        }

        if (!canFulfillOrder) {
            System.out.println("Order cannot be processed due to insufficient stock.");
            return;
        }

        // Create and store the order
        IOrder order = new Order(new ArrayList<>(cartItems.keySet()), totalPrice, currencyCode);
        orders.add(order);

        // Logic to handle order status, payment, etc.
        System.out.println("Order processed. Total Price: " + totalPrice + " " + currencyCode);
    }

    public List<IOrder> getAllOrders() {
        return orders;
    }
}
