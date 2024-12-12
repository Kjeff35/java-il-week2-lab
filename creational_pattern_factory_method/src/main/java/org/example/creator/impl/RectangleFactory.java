package org.example.creator.impl;

import org.example.creator.ShapeFactory;
import org.example.products.Shape;
import org.example.products.impl.Circle;
import org.example.products.impl.Rectangle;

public class RectangleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}
