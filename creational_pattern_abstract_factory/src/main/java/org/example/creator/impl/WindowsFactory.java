package org.example.creator.impl;

import org.example.creator.UIComponentFactory;
import org.example.products.Button;
import org.example.products.Checkbox;
import org.example.products.impl.WindowsButton;
import org.example.products.impl.WindowsCheckbox;

public class WindowsFactory implements UIComponentFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
