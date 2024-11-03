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
import gildedRoseReborn.supporting.discountPromotions.models.Promotion;
import gildedRoseReborn.supporting.discountPromotions.services.DiscountService;
import gildedRoseReborn.generic.ui.UserInterface;
import gildedRoseReborn.supporting.discountPromotions.services.PromotionService;
import gildedRoseReborn.supporting.report.services.ReportModule;
import gildedRoseReborn.supporting.report.services.ReportService;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize services
        CurrencyService currencyService = new CurrencyService();
        IProductService productService = new ProductService();
        IPricingEngine IPricingEngine = new PricingEngine(currencyService);
        PromotionService promotionService = new PromotionService();
        IDiscountService IDiscountService = new DiscountService(List.of(new Discount("Bulk Discount", 10, 5)), new PromotionService());
        ICartService ICartService = new CartService(productService);
        IOrderService IOrderService = new OrderService(productService);
        ReportService reportService = new ReportService();

        // Example products
        Priceable legendarySword = new LegendaryItem("Legendary sword", 1.0, 70, 10, new Date(2024, 10, 25));
        Priceable conjuredItem = new ConjuredItem("Conjured Item", 1.5, 50, 5, new Date(2024, 10, 21));
        Priceable genericProduct = new GenericProduct("Generic product", 2, 15, 4, new Date(2024, 10, 23));
        Priceable cheesyPeesy = new Cheese("Aging Brie", 2, 10, 4, new Date(2024, 10, 21));
        Priceable concertPasses = new BackstagePass("Tickets to concert for Arch Enemy", 3, 12, 5, new Date(2024, 10, 19));

        // Adding products to simulate a catalog
        ICartService.addToCart(legendarySword, 3);  // Adds 3 Apples to cart
        ICartService.addToCart(conjuredItem, 2);  // Adds 2 Bananas to cart
        ICartService.addToCart(genericProduct, 1);  // Adds 1 Legendary Sword to cart
        ICartService.addToCart(cheesyPeesy, 5);
        ICartService.addToCart(concertPasses, 2);

        // User Interface for interacting with the system
        UserInterface ui = new UserInterface(ICartService, IPricingEngine, IDiscountService, IOrderService, productService, reportService);
        ui.start();
    }
}
