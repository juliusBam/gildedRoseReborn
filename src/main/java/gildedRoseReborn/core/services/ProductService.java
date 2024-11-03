package gildedRoseReborn.core.services;

import gildedRoseReborn.core.contracts.models.Priceable;
import gildedRoseReborn.core.contracts.services.IProductService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService implements IProductService {
    // Map to hold products and their quantities
    private Map<Priceable, Integer> productCatalog;

    public ProductService() {
        this.productCatalog = new HashMap<>();
    }

    // Adds a new product with specified quantity to the catalog
    @Override
    public void addProduct(Priceable product, int quantity) {
        productCatalog.put(product, productCatalog.getOrDefault(product, 0) + quantity);
        System.out.println(quantity + " units of " + product.getName() + " added to the catalog.");
    }

    // Removes a product from the catalog by name
    @Override
    public void removeProduct(String productName) {
        productCatalog.keySet().removeIf(product -> product.getName().equalsIgnoreCase(productName));
        System.out.println(productName + " removed from the catalog.");
    }

    // Searches for a product by name
    @Override
    public Priceable findProductByName(String name) {
        return productCatalog.keySet().stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    // Lists all available products
    @Override
    public Map<Priceable, Integer> getAllProducts() {
        return new HashMap<>(productCatalog);
    }

    // Lists all products by category
    @Override
    public List<Priceable> getProductsByCategory(String category) {
        return productCatalog.keySet().stream()
                .filter(product -> product.getClass().getSimpleName().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // Lists all products below a certain price at the current date
    @Override
    public List<Priceable> getProductsBelowPrice(double maxPrice, Date actualDate) {
        return productCatalog.keySet().stream()
                .filter(product -> product.calculatePrice(actualDate) <= maxPrice)
                .collect(Collectors.toList());
    }

    // Lists all products with a base quality above a given threshold
    @Override
    public List<Priceable> getProductsByMinimumQuality(int minQuality) {
        return productCatalog.keySet().stream()
                .filter(product -> product.getBaseQuality() >= minQuality)
                .collect(Collectors.toList());
    }

    // Updates the quantity of an existing product by name
    @Override
    public void updateProductQuantity(String productName, int quantity) {
        productCatalog.keySet().stream()
                .filter(product -> product.getName().equalsIgnoreCase(productName))
                .findFirst()
                .ifPresent(product -> productCatalog.put(product, quantity));
        System.out.println("Quantity of " + productName + " updated to " + quantity + " units.");
    }

    // Decreases the quantity of a product when an item is purchased
    @Override
    public void decreaseProductQuantity(Priceable product, int quantity) {
        productCatalog.computeIfPresent(product, (key, oldQuantity) -> {
            int newQuantity = oldQuantity - quantity;
            if (newQuantity < 0) {
                System.out.println("Not enough stock for " + product.getName());
                return oldQuantity; // No change if insufficient stock
            }
            System.out.println(quantity + " units of " + product.getName() + " purchased.");
            return newQuantity;
        });
    }

    @Override
    public int getProductQuantity(Priceable product) {
        return productCatalog.getOrDefault(product, 0);
    }
}