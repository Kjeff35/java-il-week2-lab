package org.example.adapter;

import org.example.legacy.LegacyProcessor;
import org.example.modern.ModernPaymentProcessor;

public class PaymentProcessorAdapter implements ModernPaymentProcessor {
    private final LegacyProcessor legacyProcessor;

    public PaymentProcessorAdapter(LegacyProcessor legacyProcessor) {
        this.legacyProcessor = legacyProcessor;
    }

    @Override
    public void pay(String userId, double amount) {
        legacyProcessor.processPayment(userId, amount);
    }
}
