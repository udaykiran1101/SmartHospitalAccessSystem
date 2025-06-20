package main.model.utils;

import main.model.monitor.VitalSigns;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class AccessLogger {

    private static final String LOG_FILE = "logs/access_log.txt";
    private static final String VITALS_LOG_FILE = "logs/vitals_log.txt";

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
        fw.write(Encryptor.encrypt(content) + "\n");
    } catch (IOException e) {
        System.err.println("Logging failed: " + e.getMessage());
    }
}

  public static void printDecryptedLog(String filename) {
    try (Scanner scanner = new Scanner(new java.io.File(filename))) {
        while (scanner.hasNextLine()) {
            String encryptedLine = scanner.nextLine();
            System.out.println(Encryptor.decrypt(encryptedLine));
        }
    } catch (Exception e) {
        System.out.println("❌ Failed to read or decrypt log: " + e.getMessage());
    }
}
}
