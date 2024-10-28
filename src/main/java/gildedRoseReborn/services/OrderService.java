package gildedRoseReborn.services;

// OrderService.java
import gildedRoseReborn.engines.PricingEngine;
import gildedRoseReborn.entities.BaseProduct;
import gildedRoseReborn.entities.Order;
import gildedRoseReborn.managers.DiscountManager;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public void processOrder(CartService cartService, String currencyCode) {
        double totalPrice = cartService.calculateTotalPrice(new PricingEngine(new CurrencyService()), new DiscountManager(List.of()), currencyCode);
        List<BaseProduct> orderedProducts = new ArrayList<>(cartService.getCartItems().keySet());

        Order order = new Order(orderedProducts, totalPrice, currencyCode);
        orders.add(order);

        // Logic to handle order status, payment, etc.
        System.out.println("Order processed. Total Price: " + totalPrice + " " + currencyCode);
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}
