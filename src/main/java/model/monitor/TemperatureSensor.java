package main.model.monitor;

import java.util.Random;

public class TemperatureSensor extends Sensor {

    public TemperatureSensor() {
        super("Temperature Sensor");
    }

    @Override
    public double readValue() {
        // Simulate body temperature between 35.5 and 40.0 °C
        return 35.5 + new Random().nextDouble() * 4.5;
    }

    @Override
    public boolean isCritical(double value) {
        return value > 38.0; // High fever
    }
}
