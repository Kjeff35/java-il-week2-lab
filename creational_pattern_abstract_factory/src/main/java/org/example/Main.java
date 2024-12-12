package org.example;

import org.example.creator.UIComponentFactory;
import org.example.creator.impl.ChromeBookFactory;
import org.example.creator.impl.WindowsFactory;
import org.example.products.Button;
import org.example.products.Checkbox;

public class Main {
    public static void main(String[] args) {
        UIComponentFactory windowsFactory = new WindowsFactory();

        Button windowsButton = windowsFactory.createButton();
        Checkbox windowsCheckbox = windowsFactory.createCheckbox();

        windowsButton.render();
        windowsCheckbox.render();

        UIComponentFactory chromeBookFactory = new ChromeBookFactory();
        Button chromeBookButton = chromeBookFactory.createButton();
        Checkbox chromeBookCheckbox = chromeBookFactory.createCheckbox();

        chromeBookButton.render();
        chromeBookCheckbox.render();

    }
}