package gildedRoseReborn.generic.cartOrder.services;

// OrderService.java
import gildedRoseReborn.core.contracts.services.IProductService;
import gildedRoseReborn.core.services.PricingEngine;
import gildedRoseReborn.generic.cartOrder.contracts.models.IOrder;
import gildedRoseReborn.generic.cartOrder.contracts.services.ICartService;
import gildedRoseReborn.generic.cartOrder.contracts.services.IOrderService;
import gildedRoseReborn.generic.cartOrder.entities.Order;
import gildedRoseReborn.core.contracts.models.Priceable;
import gildedRoseReborn.supporting.currency.CurrencyService;
import gildedRoseReborn.supporting.discountPromotions.services.DiscountService;
import gildedRoseReborn.supporting.discountPromotions.services.PromotionService;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrderService {

    private List<IOrder> orders = new ArrayList<>();
    private IProductService productService;  // Use IProductService interface

    // Constructor to inject IProductService
    public OrderService(IProductService productService) {
        this.productService = productService;
    }

    public void processOrder(ICartService cartService, String currencyCode) {
        List<Priceable> orderedProducts = new ArrayList<>(cartService.getCartItems().keySet());

        // Check if enough products are available
        boolean canFulfillOrder = true;
        for (Priceable product : orderedProducts) {
            int cartQuantity = cartService.getCartItems().get(product);
            int availableQuantity = productService.getProductQuantity(product);
            if (availableQuantity < cartQuantity) {
                System.out.println("Insufficient stock for " + product.getName() + ". Available: " + availableQuantity + ", Requested: " + cartQuantity);
                canFulfillOrder = false;
            }
        }

        if (!canFulfillOrder) {
            System.out.println("Order cannot be processed due to insufficient stock.");
            return;
        }

        // Calculate total price if products are available
        double totalPrice = cartService.calculateTotalPrice(new PricingEngine(new CurrencyService()), new DiscountService(List.of(), new PromotionService()), currencyCode);

        // Create and store the order
        IOrder order = new Order(orderedProducts, totalPrice, currencyCode);
        orders.add(order);

        // Logic to handle order status, payment, etc.
        System.out.println("Order processed. Total Price: " + totalPrice + " " + currencyCode);
    }

    public List<IOrder> getAllOrders() {
        return orders;
    }
}
