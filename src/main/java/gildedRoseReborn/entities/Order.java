package gildedRoseReborn.entities;

import gildedRoseReborn.entities.products.BaseProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order {
    private List<BaseProduct> orderedProducts;
    private double totalPrice;
    private String currency;

    public Order(List<BaseProduct> orderedProducts, double totalPrice, String currency) {
        this.orderedProducts = orderedProducts;
        this.totalPrice = totalPrice;
        this.currency = currency;
    }
}
