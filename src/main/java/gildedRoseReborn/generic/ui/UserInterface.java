package gildedRoseReborn.generic.ui;

import gildedRoseReborn.core.contracts.models.Priceable;
import gildedRoseReborn.generic.cartOrder.contracts.services.ICartService;
import gildedRoseReborn.generic.cartOrder.contracts.services.IOrderService;
import gildedRoseReborn.supporting.discountPromotions.contracts.services.IDiscountService;
import gildedRoseReborn.supporting.report.services.ReportModule;

import java.util.Date;
import java.util.Scanner;

public class UserInterface {
    private ICartService ICartService;
    private gildedRoseReborn.core.contracts.services.IPricingEngine IPricingEngine;
    private IDiscountService IDiscountService;
    private IOrderService IOrderService;
    private ReportModule reportModule;

    public UserInterface(ICartService ICartService, gildedRoseReborn.core.contracts.services.IPricingEngine IPricingEngine, IDiscountService IDiscountService, IOrderService IOrderService, ReportModule reportModule) {
        this.ICartService = ICartService;
        this.IPricingEngine = IPricingEngine;
        this.IDiscountService = IDiscountService;
        this.IOrderService = IOrderService;
        this.reportModule = reportModule;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Product Management System =====");
            System.out.println("1. View Cart Total");
            System.out.println("2. Process Order");
            System.out.println("3. Generate Reports");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // View cart total in different currencies
                    System.out.println("Enter currency code (e.g., USD, EUR, GBP):");
                    scanner.nextLine();  // Consume newline
                    String currencyCode = scanner.nextLine();

                    for (Priceable product : this.ICartService.getCartItems().keySet()) {
                        System.out.println("Product Name: " + product.getName() + " x" + this.ICartService.getCartItems().get(product) + " times");
                        System.out.println("############# Base price " + product.calculatePrice(new Date()));
                    }

                    double total = ICartService.calculateTotalPrice(IPricingEngine, IDiscountService, currencyCode);
                    System.out.println("Cart Total in " + currencyCode + ": " + total);
                    break;

                case 2:
                    // Process order
                    System.out.println("Enter currency code for order (e.g., USD, EUR, GBP):");
                    scanner.nextLine();  // Consume newline
                    String orderCurrency = scanner.nextLine();

                    IOrderService.processOrder(ICartService, orderCurrency);
                    ICartService.clearCart(); // Clear the cart after processing the order
                    break;

                case 3:
                    // Generate reports
                    System.out.println("Generating Sales Report:");
                    reportModule.generateSalesReport();

                    System.out.println("\nGenerating Inventory Status Report:");
                    reportModule.generateInventoryStatus();

                    System.out.println("\nGenerating Currency Usage Report:");
                    reportModule.generateCurrencyUsage();
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
}
