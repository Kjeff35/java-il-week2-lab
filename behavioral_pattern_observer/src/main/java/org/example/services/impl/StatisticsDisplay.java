package org.example.services.impl;

import org.example.services.Observer;

import java.util.ArrayList;
import java.util.List;

public class StatisticsDisplay implements Observer {
    private final List<Float> temperatureReadings = new ArrayList<>();
    private final List<Float> humidityReadings = new ArrayList<>();
    private final List<Float> precipitationReadings = new ArrayList<>();

    @Override
    public void update(float temperature, float humidity, float precipitation) {
        temperatureReadings.add(temperature);
        humidityReadings.add(humidity);
        precipitationReadings.add(precipitation);
        display();
    }

    public void display() {
        float temperatureAverage = (float) temperatureReadings.stream().mapToDouble(val -> val).average().orElse(0.0);
        float humidityAverage = (float) humidityReadings.stream().mapToDouble(val -> val).average().orElse(0.0);
        float precipitationAverage = (float) precipitationReadings.stream().mapToDouble(val -> val).average().orElse(0.0);

        System.out.println("Average temperature: " + temperatureAverage + "F degrees");
        System.out.println("Average humidity: " + humidityAverage + "%");
        System.out.println("Average precipitation: " + precipitationAverage + " inches");
    }
}
