package gildedRoseReborn.generic.cartOrder.contracts.services;

import gildedRoseReborn.generic.cartOrder.contracts.models.IOrder;
import gildedRoseReborn.generic.cartOrder.entities.Order;

import java.util.List;

public interface IOrderService {
    void processOrder(ICartService ICartService, String currencyCode);

    List<IOrder> getAllOrders();
}
