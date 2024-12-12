package org.example;

import org.example.adapter.PaymentProcessorAdapter;
import org.example.legacy.LegacyPaymentProcessor;
import org.example.legacy.LegacyProcessor;
import org.example.modern.ModernPaymentProcessor;

public class Main {
    public static void main(String[] args) {
        LegacyProcessor legacyProcessor = new LegacyPaymentProcessor();
        ModernPaymentProcessor adapter = new PaymentProcessorAdapter(legacyProcessor);

        // Modern API usage
        adapter.pay("user", 158);
    }
}