package gildedRoseReborn.ui;

import gildedRoseReborn.engines.PricingEngine;
import gildedRoseReborn.entities.products.BaseProduct;
import gildedRoseReborn.managers.DiscountManager;
import gildedRoseReborn.services.CartService;
import gildedRoseReborn.services.OrderService;
import gildedRoseReborn.services.ReportsModule;

import java.util.Date;
import java.util.Scanner;

public class UserInterface {
    private CartService cartService;
    private PricingEngine pricingEngine;
    private DiscountManager discountManager;
    private OrderService orderService;
    private ReportsModule reportsModule;

    public UserInterface(CartService cartService, PricingEngine pricingEngine, DiscountManager discountManager, OrderService orderService, ReportsModule reportsModule) {
        this.cartService = cartService;
        this.pricingEngine = pricingEngine;
        this.discountManager = discountManager;
        this.orderService = orderService;
        this.reportsModule = reportsModule;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Product Management System =====");
//            System.out.println("1. Add Product to Cart");
//            System.out.println("2. Remove Product from Cart");
            System.out.println("1. View Cart Total");
            System.out.println("2. Process Order");
            System.out.println("3. Generate Reports");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
//                case 1:
//                    // Add product to cart
//                    System.out.println("Enter Product Name:");
//                    scanner.nextLine();  // Consume newline
//                    String productName = scanner.nextLine();
//                    System.out.println("Enter Quantity:");
//                    int quantity = scanner.nextInt();
//
//                    BaseProduct product = findProductByName(productName);
//                    if (product != null) {
//                        cartService.addToCart(product, quantity);
//                        System.out.println(quantity + " " + productName + "(s) added to the cart.");
//                    } else {
//                        System.out.println("Product not found.");
//                    }
//                    break;

//                case 2:
//                    // Remove product from cart
//                    System.out.println("Enter Product Name:");
//                    scanner.nextLine();  // Consume newline
//                    String removeProductName = scanner.nextLine();
//                    System.out.println("Enter Quantity to Remove:");
//                    int removeQuantity = scanner.nextInt();
//
//                    Product removeProduct = findProductByName(removeProductName);
//                    if (removeProduct != null) {
//                        cartService.removeFromCart(removeProduct, removeQuantity);
//                        System.out.println(removeQuantity + " " + removeProductName + "(s) removed from the cart.");
//                    } else {
//                        System.out.println("Product not found.");
//                    }
//                    break;

                case 1:
                    // View cart total in different currencies
                    System.out.println("Enter currency code (e.g., USD, EUR, GBP):");
                    scanner.nextLine();  // Consume newline
                    String currencyCode = scanner.nextLine();

                    for (BaseProduct product : this.cartService.getCartItems().keySet()) {
                        System.out.println("Product Name: " + product.getName() + " x" + this.cartService.getCartItems().get(product) + " times");
                        System.out.println("############# Base price" + product.calculatePrice(new Date()));
                    }

                    double total = cartService.calculateTotalPrice(pricingEngine, discountManager, currencyCode);
                    System.out.println("Cart Total in " + currencyCode + ": " + total);
                    break;

                case 2:
                    // Process order
                    System.out.println("Enter currency code for order (e.g., USD, EUR, GBP):");
                    scanner.nextLine();  // Consume newline
                    String orderCurrency = scanner.nextLine();

                    orderService.processOrder(cartService, orderCurrency);
                    cartService.clearCart(); // Clear the cart after processing the order
                    break;

                case 3:
                    // Generate reports
                    System.out.println("Generating Sales Report:");
                    reportsModule.generateSalesReport();

                    System.out.println("\nGenerating Inventory Status Report:");
                    reportsModule.generateInventoryStatus();

                    System.out.println("\nGenerating Currency Usage Report:");
                    reportsModule.generateCurrencyUsage();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

//    // Helper method to simulate product catalog search
//    private BaseProduct findProductByName(String name) {
//        // Example lookup; in a real application, this would query a database or service
//        switch (name.toLowerCase()) {
//            case "apple": return new Product("Apple", 1.0, "Fruit");
//            case "banana": return new Product("Banana", 0.5, "Fruit");
//            case "legendary sword": return new Product("Legendary Sword", 150.0, "Legendary");
//            default: return null;
//        }
//    }
}
