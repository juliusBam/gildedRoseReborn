package gildedRoseReborn.generic.ui;

import gildedRoseReborn.core.contracts.models.Priceable;
import gildedRoseReborn.core.contracts.services.IPricingEngine;
import gildedRoseReborn.core.contracts.services.IProductService;
import gildedRoseReborn.generic.cartOrder.contracts.services.ICartService;
import gildedRoseReborn.generic.cartOrder.contracts.services.IOrderService;
import gildedRoseReborn.supporting.discountPromotions.contracts.services.IDiscountService;
import gildedRoseReborn.supporting.report.contracts.IReportUI;
import gildedRoseReborn.supporting.report.services.ReportModule;
import gildedRoseReborn.supporting.report.services.ReportService;
import gildedRoseReborn.supporting.report.ui.ReportUI;

import java.util.Scanner;

public class UserInterface {
    private ICartService cartService;
    private IPricingEngine pricingEngine;
    private IDiscountService discountService;
    private IOrderService orderService;
    private IProductService productService;

    private ProductCatalogUI productCatalogUI;
    private CartUI cartUI;
    private OrderUI orderUI;
    private IReportUI reportUI;

    public UserInterface(ICartService cartService, IPricingEngine pricingEngine, IDiscountService discountService, IOrderService orderService, IProductService productService, ReportService reportService) {
        this.cartService = cartService;
        this.pricingEngine = pricingEngine;
        this.discountService = discountService;
        this.orderService = orderService;
        this.productService = productService;

        this.productCatalogUI = new ProductCatalogUI(productService);
        this.cartUI = new CartUI(cartService, pricingEngine, discountService);
        this.orderUI = new OrderUI(orderService);
        this.reportUI = new ReportUI(reportService, new ReportModule());
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Product Management System =====");
            System.out.println("1. View All Stored Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Remove Product from Cart");
            System.out.println("4. View Cart Total");
            System.out.println("5. Process Order");
            System.out.println("6. Generate Reports");
            System.out.println("7. List Processed Orders");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    productCatalogUI.viewAllStoredProducts(); // View all stored products
                    break;

                case 2:
                    // Add product to cart
                    System.out.println("Enter Product Name:");
                    scanner.nextLine();  // Consume newline
                    String productName = scanner.nextLine();
                    System.out.println("Enter Quantity:");
                    int quantityToAdd = scanner.nextInt();

                    Priceable productToAdd = productService.findProductByName(productName); // Assuming this method exists
                    if (productToAdd != null) {
                        cartUI.addToCart(productToAdd, quantityToAdd); // Add to cart
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    // Remove product from cart
                    System.out.println("Enter Product Name:");
                    scanner.nextLine();  // Consume newline
                    String productNameToRemove = scanner.nextLine();
                    System.out.println("Enter Quantity to Remove:");
                    int quantityToRemove = scanner.nextInt();

                    Priceable productToRemove = productService.findProductByName(productNameToRemove); // Assuming this method exists
                    if (productToRemove != null) {
                        cartUI.removeFromCart(productToRemove, quantityToRemove); // Remove from cart
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    // View cart total
                    System.out.println("Enter currency code (e.g., USD, EUR, GBP):");
                    scanner.nextLine();  // Consume newline
                    String currencyCode = scanner.nextLine();
                    cartUI.viewCartTotal(currencyCode); // View total price in the cart
                    break;

                case 5:
                    // Process order
                    System.out.println("Enter currency code for order (e.g., USD, EUR, GBP):");
                    scanner.nextLine();  // Consume newline
                    String orderCurrency = scanner.nextLine();
                    cartService.buyProducts(orderCurrency); // Process the order
                    break;

                case 6:
                    // Generate reports
                    reportUI.generateReports();
                    break;

                case 7:
                    // List processed orders
                    orderUI.listProcessedOrders();
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
