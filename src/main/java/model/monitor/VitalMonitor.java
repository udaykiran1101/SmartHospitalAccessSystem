package main.model.monitor;

import main.model.monitor.VitalSigns;
import java.util.ArrayList;
import java.util.List;

public class VitalMonitor {
    private List<Sensor> sensors;

    public VitalMonitor() {
        sensors = new ArrayList<>();
    }

    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
    }

    public void checkVitals() {
        System.out.println("🔍 Vital Check Report:");
        for (Sensor sensor : sensors) {
            double value = sensor.readValue();
            System.out.printf("%s: %.2f%n", sensor.getName(), value);
            if (sensor.isCritical(value)) {
                System.out.printf("⚠️ ALERT: %s reading is critical! (%.2f)%n", sensor.getName(), value);
            }
        }
        System.out.println("-----------------------------------");
    }

    // ✅ This should be *inside* the class
    public VitalSigns getVitalsSnapshot() {
        double temperature = 0, heartRate = 0, oxygen = 0;

        for (Sensor sensor : sensors) {
            double value = sensor.readValue();
            if (sensor instanceof TemperatureSensor) temperature = value;
            else if (sensor instanceof HeartRateSensor) heartRate = value;
            else if (sensor instanceof OxygenSensor) oxygen = value;
        }

        return new VitalSigns(temperature, heartRate, oxygen);
    }
}
