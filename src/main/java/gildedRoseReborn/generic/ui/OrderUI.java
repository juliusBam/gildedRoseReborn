package gildedRoseReborn.generic.ui;

import gildedRoseReborn.generic.cartOrder.contracts.models.IOrder;
import gildedRoseReborn.generic.cartOrder.contracts.services.IOrderService;

import java.util.List;

public class OrderUI {
    private IOrderService orderService;

    public OrderUI(IOrderService orderService) {
        this.orderService = orderService;
    }

    public void listProcessedOrders() {
        List<IOrder> orders = orderService.getAllOrders();
        System.out.println("Processed Orders:");
        for (IOrder order : orders) {
            System.out.println("Order Total: " + order.getTotalPrice() + " " + order.getCurrency());
            // Print other order details if needed
        }
    }
}
