package org.example.facade;

import org.example.services.PaymentService;
import org.example.services.ShippingService;

public class OrderService {
    private final ShippingService shippingService;
    private final PaymentService paymentService;

    public OrderService(ShippingService shippingService, PaymentService paymentService) {
        this.shippingService = shippingService;
        this.paymentService = paymentService;
    }

    public void placeOrder(String item, int quantity, String userId, double amount) {
        if (paymentService.makePayment(userId, amount)) {
            shippingService.arrangeShipping(item, quantity, userId);
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Order placement failed.");
        }
    }

}
