package gildedRoseReborn.generic.cartOrder.contracts.services;

import gildedRoseReborn.core.contracts.models.Priceable;
import gildedRoseReborn.generic.cartOrder.contracts.models.IOrder;
import gildedRoseReborn.generic.cartOrder.entities.Order;

import java.util.List;
import java.util.Map;

public interface IOrderService {
    void processOrder(Map<Priceable, Integer> cartItems, double totalPrice, String currencyCode);

    List<IOrder> getAllOrders();
}
