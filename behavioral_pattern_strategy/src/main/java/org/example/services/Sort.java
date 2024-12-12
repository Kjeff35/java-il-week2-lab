package org.example.services;

public class Sort {
    private SortingStrategy strategy;

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] numbers) {
        if (strategy == null) {
            throw new IllegalStateException("Sorting strategy not set.");
        }
        strategy.sort(numbers);
        System.out.println("Sorted Array: " + java.util.Arrays.toString(numbers));
    }
}
