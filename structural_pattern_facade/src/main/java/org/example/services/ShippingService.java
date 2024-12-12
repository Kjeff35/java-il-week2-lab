package org.example.services;

public class ShippingService {
    public void arrangeShipping(String item, int quantity, String userId) {
        System.out.println("Shipping information: " + "\nItem: " + item + "\nQuantity: " + quantity + "\nUser ID: " + userId);
    }
}
