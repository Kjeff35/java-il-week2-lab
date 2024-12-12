package org.example.services;

public class PaymentService {
    public boolean makePayment(String userId, double amount) {
        System.out.println("Processing payment of " + amount + " for user: " + userId);
        return true;
    }
}
