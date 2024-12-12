package org.example;

import org.example.creator.ShapeFactory;
import org.example.creator.impl.CircleFactory;
import org.example.products.Shape;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new CircleFactory();
        Shape circle = shapeFactory.createShape();
        circle.draw();

    }
}