package gildedRoseReborn;

import gildedRoseReborn.core.contracts.services.IPricingEngine;
import gildedRoseReborn.core.contracts.services.IProductService;
import gildedRoseReborn.core.services.PricingEngine;
import gildedRoseReborn.core.services.ProductService;
import gildedRoseReborn.generic.cartOrder.services.CartService;
import gildedRoseReborn.generic.cartOrder.contracts.services.ICartService;
import gildedRoseReborn.generic.cartOrder.contracts.services.IOrderService;
import gildedRoseReborn.generic.cartOrder.services.OrderService;
import gildedRoseReborn.supporting.currency.CurrencyService;
import gildedRoseReborn.supporting.discountPromotions.contracts.services.IDiscountService;
import gildedRoseReborn.supporting.discountPromotions.models.Discount;
import gildedRoseReborn.core.models.*;
import gildedRoseReborn.core.contracts.models.Priceable;
import gildedRoseReborn.supporting.discountPromotions.services.DiscountService;
import gildedRoseReborn.generic.ui.UserInterface;
import gildedRoseReborn.supporting.discountPromotions.services.PromotionService;
import gildedRoseReborn.supporting.report.services.ReportService;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize services
        CurrencyService currencyService = new CurrencyService();
        IProductService productService = new ProductService();
        IPricingEngine pricingEngine = new PricingEngine(currencyService);
        PromotionService promotionService = new PromotionService();
        IDiscountService discountService = new DiscountService(List.of(new Discount("Bulk Discount", 10, 5)), promotionService);
        IOrderService orderService = new OrderService(productService);
        ICartService cartService = new CartService(productService, orderService, pricingEngine, discountService);
        ReportService reportService = new ReportService();

        // Example products
        Priceable legendarySword = new LegendaryItem("Legendary sword", 1.0, 70, 10, new Date(2024, 10, 25));
        Priceable conjuredItem = new ConjuredItem("Conjured Item", 1.5, 50, 5, new Date(2024, 10, 21));
        Priceable genericProduct = new GenericProduct("Generic product", 2, 15, 4, new Date(2024, 10, 23));
        Priceable cheesyPeesy = new Cheese("Aging Brie", 2, 10, 4, new Date(2024, 10, 21));
        Priceable concertPasses = new BackstagePass("Tickets to concert for Arch Enemy", 3, 12, 5, new Date(2024, 10, 19));

        // Adding products to simulate a catalog
        productService.addProduct(legendarySword, 3);  // Adds 3 Apples to cart
        productService.addProduct(conjuredItem, 2);  // Adds 2 Bananas to cart
        productService.addProduct(genericProduct, 1);  // Adds 1 Legendary Sword to cart
        productService.addProduct(cheesyPeesy, 5);
        productService.addProduct(concertPasses, 2);

//        Priceable item1 = new LegendaryItem("Excalibur", 2.5, 80, 15, new Date(2024 - 1900, 9, 30));
//        Priceable item2 = new ConjuredItem("Magic Potion", 1.8, 45, 3, new Date(2024 - 1900, 9, 29));
//        Priceable item3 = new GenericProduct("Ordinary Widget", 3.5, 20, 10, new Date(2024 - 1900, 10, 1));
//        Priceable item4 = new Cheese("Vintage Cheddar", 1.9, 30, 2, new Date(2024 - 1900, 10, 15));
//        Priceable item5 = new BackstagePass("Concert Tickets for Symphony X", 4.5, 20, 7, new Date(2024 - 1900, 9, 25));


        // User Interface for interacting with the system
        UserInterface ui = new UserInterface(cartService, pricingEngine, discountService, orderService, productService, reportService);
        ui.start();
    }
}
