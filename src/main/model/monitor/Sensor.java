package main.model.monitor;

public abstract class Sensor {
    protected String name;

    public Sensor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Each sensor should return its value as a string and trigger alert if needed
    public abstract double readValue();
    public abstract boolean isCritical(double value);
}
