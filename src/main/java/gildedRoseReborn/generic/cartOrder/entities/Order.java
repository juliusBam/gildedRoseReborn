package gildedRoseReborn.generic.cartOrder.entities;

import gildedRoseReborn.core.contracts.models.Priceable;
import gildedRoseReborn.generic.cartOrder.contracts.models.IOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order implements IOrder {
    private List<Priceable> orderedProducts;
    private double totalPrice;
    private String currency;

    public Order(List<Priceable> orderedProducts, double totalPrice, String currency) {
        this.orderedProducts = orderedProducts;
        this.totalPrice = totalPrice;
        this.currency = currency;
    }
}
