package gildedRoseReborn;

import gildedRoseReborn.engines.PricingEngine;
import gildedRoseReborn.entities.Discount;
import gildedRoseReborn.entities.Product;
import gildedRoseReborn.managers.DiscountManager;
import gildedRoseReborn.services.*;
import gildedRoseReborn.ui.UserInterface;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize services
        CurrencyService currencyService = new CurrencyService();
        PricingEngine pricingEngine = new PricingEngine(currencyService);
        DiscountManager discountManager = new DiscountManager(List.of(new Discount("Bulk Discount", 10, 5)));
        CartService cartService = new CartService();
        OrderService orderService = new OrderService();
        ReportsService reportsService = new ReportsService();
        ReportsModule reportsModule = new ReportsModule(reportsService);

        // Example products
        Product product1 = new Product("Apple", 1.0, "Fruit");
        Product product2 = new Product("Banana", 0.5, "Fruit");
        Product product3 = new Product("Legendary Sword", 150.0, "Legendary");

        // Adding products to simulate a catalog
        cartService.addToCart(product1, 3);  // Adds 3 Apples to cart
        cartService.addToCart(product2, 2);  // Adds 2 Bananas to cart
        cartService.addToCart(product3, 1);  // Adds 1 Legendary Sword to cart

        // User Interface for interacting with the system
        UserInterface ui = new UserInterface(cartService, pricingEngine, discountManager, orderService, reportsModule);
        ui.start();
    }
}
