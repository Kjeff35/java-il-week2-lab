package org.example.creator.impl;

import org.example.creator.ShapeFactory;
import org.example.products.Shape;
import org.example.products.impl.Circle;

public class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}
