package org.example;

import org.example.facade.OrderService;
import org.example.services.PaymentService;
import org.example.services.ShippingService;

public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        ShippingService shippingService = new ShippingService();
        OrderService orderFacade = new OrderService(shippingService, paymentService);
        orderFacade.placeOrder("Laptop", 1, "user1", 1200.50);
    }
}