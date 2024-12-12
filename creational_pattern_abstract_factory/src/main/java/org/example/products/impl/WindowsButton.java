package org.example.products.impl;

import org.example.products.Button;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering windows button");
    }
}
