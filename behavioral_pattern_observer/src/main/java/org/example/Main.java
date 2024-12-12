package org.example;

import org.example.services.impl.ClimateData;
import org.example.services.impl.StatisticsDisplay;
import org.example.services.impl.WeatherDisplay;

public class Main {
    public static void main(String[] args) {
        ClimateData climateData = new ClimateData();

        WeatherDisplay weatherDisplay = new WeatherDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();

        climateData.registerObserver(weatherDisplay);
        climateData.registerObserver(statisticsDisplay);

        climateData.setMeasurements(80,34, 23);
        climateData.setMeasurements(10,23, 70);
    }
}