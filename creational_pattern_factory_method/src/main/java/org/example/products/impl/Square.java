package org.example.products.impl;

import org.example.products.Shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}
