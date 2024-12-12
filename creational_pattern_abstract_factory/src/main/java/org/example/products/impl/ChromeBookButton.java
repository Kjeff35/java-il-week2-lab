package org.example.products.impl;

import org.example.products.Button;

public class ChromeBookButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering ChromeBook button");
    }
}
