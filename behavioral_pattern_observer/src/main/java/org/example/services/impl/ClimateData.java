package org.example.services.impl;

import org.example.services.Observer;
import org.example.services.Subject;

import java.util.ArrayList;
import java.util.List;

public class ClimateData implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float precipitation;

    public void setMeasurements(float temperature, float humidity, float precipitation) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.precipitation = precipitation;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, precipitation);
        }
    }
}
