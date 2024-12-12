package org.example.creator.impl;

import org.example.creator.UIComponentFactory;
import org.example.products.Button;
import org.example.products.Checkbox;
import org.example.products.impl.ChromeBookButton;
import org.example.products.impl.ChromeBookCheckbox;

public class ChromeBookFactory implements UIComponentFactory {
    @Override
    public Button createButton() {
        return new ChromeBookButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new ChromeBookCheckbox();
    }
}
