package gildedRoseReborn.core.contracts.services;

import gildedRoseReborn.core.contracts.models.Priceable;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IProductService {
    // Adds a new product with specified quantity to the catalog
    void addProduct(Priceable product, int quantity);

    // Removes a product from the catalog by name
    void removeProduct(String productName);

    // Searches for a product by name
    Priceable findProductByName(String name);

    // Lists all available products
    Map<Priceable, Integer> getAllProducts();

    // Lists all products by category
    List<Priceable> getProductsByCategory(String category);

    // Lists all products below a certain price at the current date
    List<Priceable> getProductsBelowPrice(double maxPrice, Date actualDate);

    // Lists all products with a base quality above a given threshold
    List<Priceable> getProductsByMinimumQuality(int minQuality);

    // Updates the quantity of an existing product by name
    void updateProductQuantity(String productName, int quantity);

    // Decreases the quantity of a product when an item is purchased
    void decreaseProductQuantity(Priceable product, int quantity);

    int getProductQuantity(Priceable product);
}
