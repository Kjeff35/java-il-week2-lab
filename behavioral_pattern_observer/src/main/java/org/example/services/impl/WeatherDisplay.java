package org.example.services.impl;

import org.example.services.Observer;

public class WeatherDisplay implements Observer {
    private float temperature;
    private float humidity;
    private float precipitation;

    @Override
    public void update(float temperature, float humidity, float precipitation) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.precipitation = precipitation;
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity" + precipitation + "in precipitation");
    }
}
