package main.model.utils;

import main.model.monitor.VitalSigns;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class AccessLogger {

    private static final String LOG_FILE = "main/logs/access_log.txt";
    private static final String VITALS_LOG_FILE = "main/logs/vitals_log.txt";

    public static void logAccess(String personId, String roomId, boolean granted) {
        String timestamp = LocalDateTime.now().toString();
        String entry = String.format("[%s] Person %s attempted access to Room %s: %s\n",
                timestamp, personId, roomId, granted ? "GRANTED" : "DENIED");
        writeToFile(LOG_FILE, entry);
    }

    public static void logVitals(String personId, VitalSigns vitals) {
        String timestamp = LocalDateTime.now().toString();
        String entry = String.format("[%s] Vitals for %s: Temp: %.1f°C, HR: %.0f BPM, SpO2: %.0f%%\n",
                timestamp, personId,
                vitals.getTemperature(),
                vitals.getHeartRate(),
                vitals.getOxygenLevel());
        writeToFile(VITALS_LOG_FILE, entry);
    }

    private static void writeToFile(String filename, String content) {
        try (FileWriter fw = new FileWriter(filename, true)) {
            fw.write(content);
        } catch (IOException e) {
            System.err.println("Logging failed: " + e.getMessage());
        }
    }

}
