package org.example;

import org.example.services.Sort;
import org.example.services.impl.BubbleSort;
import org.example.services.impl.QuickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sort context = new Sort();

        int[] numbers = {5, 2, 9, 1, 5, 6};

        System.out.println("Original Array: " + Arrays.toString(numbers));

        context.setStrategy(new BubbleSort());
        context.executeStrategy(numbers.clone());

        context.setStrategy(new QuickSort());
        context.executeStrategy(numbers.clone());
    }
}