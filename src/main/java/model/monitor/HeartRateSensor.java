package main.model.monitor;

import java.util.Random;

public class HeartRateSensor extends Sensor {

    public HeartRateSensor() {
        super("Heart Rate Sensor");
    }

    @Override
    public double readValue() {
        // Simulate heart rate between 60 and 120 BPM
        return 60 + new Random().nextInt(61);
    }

    @Override
    public boolean isCritical(double value) {
        return value < 60 || value > 100; // Normal adult resting HR: 60–100
    }
}

