package org.example.legacy;

public class LegacyPaymentProcessor implements LegacyProcessor{
    public void processPayment(String account, double amount) {
        System.out.println("Processing payment through legacy system: " + amount + " to account " + account);
    }
}
