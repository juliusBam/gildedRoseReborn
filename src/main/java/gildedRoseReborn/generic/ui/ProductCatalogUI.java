package gildedRoseReborn.generic.ui;

import gildedRoseReborn.core.contracts.models.Priceable;
import gildedRoseReborn.core.contracts.services.IProductService;
import gildedRoseReborn.generic.cartOrder.contracts.services.ICartService;

import java.util.Map;

public class ProductCatalogUI {

    private IProductService productService;

    public ProductCatalogUI(IProductService productService) {
        this.productService = productService;
    }

    // Method to view all stored products with their quantities
    public void viewAllStoredProducts() {
        System.out.println("Available Products:");
        Map<Priceable, Integer> storedProducts = productService.getAllProducts();

        for (Map.Entry<Priceable, Integer> entry : storedProducts.entrySet()) {
            Priceable product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Product Name: " + product.getName() + ", Quantity: " + quantity);
        }
    }

}
