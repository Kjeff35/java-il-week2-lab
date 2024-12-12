package org.example.creator;

import org.example.products.Button;
import org.example.products.Checkbox;

public interface UIComponentFactory {
    Button createButton();
    Checkbox createCheckbox();
}
