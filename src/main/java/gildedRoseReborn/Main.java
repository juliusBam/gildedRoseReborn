package gildedRoseReborn;

import gildedRoseReborn.engines.PricingEngine;
import gildedRoseReborn.entities.Discount;
import gildedRoseReborn.entities.products.*;
import gildedRoseReborn.managers.DiscountManager;
import gildedRoseReborn.services.*;
import gildedRoseReborn.ui.UserInterface;

import java.util.Date;
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
        BaseProduct legendarySword = new LegendaryItem("Legendary sword", 1.0, 70, 10, new Date(2024, 10, 25));
        BaseProduct conjuredItem = new ConjuredItem("Conjured Item", 1.5, 50, 5, new Date(2024, 10, 21));
        BaseProduct genericProduct = new GenericProduct("Generic product", 2, 15, 4, new Date(2024, 10, 23));
        BaseProduct cheesyPeesy = new Cheese("Aging Brie", 2, 10, 4, new Date(2024, 10, 21));
        BaseProduct concertPasses = new BackstagePass("Tickets to concert for Arch Enemy", 3, 12, 5, new Date(2024, 10, 19));

        // Adding products to simulate a catalog
        cartService.addToCart(legendarySword, 3);  // Adds 3 Apples to cart
        cartService.addToCart(conjuredItem, 2);  // Adds 2 Bananas to cart
        cartService.addToCart(genericProduct, 1);  // Adds 1 Legendary Sword to cart
        cartService.addToCart(cheesyPeesy, 5);
        cartService.addToCart(concertPasses, 2);

        // User Interface for interacting with the system
        UserInterface ui = new UserInterface(cartService, pricingEngine, discountManager, orderService, reportsModule);
        ui.start();
    }
}
