package main.model.monitor;

import java.time.LocalDateTime;

public class VitalSigns {
    private double temperature;
    private double heartRate;
    private double oxygenLevel;
    private LocalDateTime timestamp;

    public VitalSigns(double temperature, double heartRate, double oxygenLevel) {
        this.temperature = temperature;
        this.heartRate = heartRate;
        this.oxygenLevel = oxygenLevel;
        this.timestamp = LocalDateTime.now();
    }

    public double getTemperature() { return temperature; }
    public double getHeartRate() { return heartRate; }
    public double getOxygenLevel() { return oxygenLevel; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return String.format("Vitals @ %s - Temp: %.1f°C, HR: %.0f BPM, SpO2: %.0f%%",
                timestamp.toString(), temperature, heartRate, oxygenLevel);
    }
}
