package main.model.monitor;

import java.util.Random;

public class OxygenSensor extends Sensor {

    public OxygenSensor() {
        super("Oxygen Sensor");
    }

    @Override
    public double readValue() {
        // Simulate SpO₂ levels between 85% and 100%
        return 85 + new Random().nextInt(16);
    }

    @Override
    public boolean isCritical(double value) {
        return value < 92; // <92% is considered low
    }
}
