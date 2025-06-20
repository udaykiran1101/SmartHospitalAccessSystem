
package main.model.hospital;

import main.model.roles.Patient;
import main.model.monitor.*;
import main.model.room.*;
import main.model.utils.AccessLogger;

import java.util.*;

public class HospitalSystem {

    private static Map<String, Patient> patients = new HashMap<>();
    private static Map<String, Room> rooms = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void run() {
        System.out.println("🏥 Welcome to the Smart Hospital Access System CLI");

        // Preload some rooms
        rooms.put("ICU1", new ICU("ICU1"));
        rooms.put("WARD1", new Ward("WARD1"));

        while (true) {
            printMenu();
            int choice = getInt("Enter choice: ");

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> assignRoom();
                case 3 -> accessRoom();
                case 4 -> runVitalsCheck();
                case 5 -> viewPatients();
                
                case 6 -> {
                System.out.println("Access Log:");
                AccessLogger.printDecryptedLog("main/logs/access_log.txt");
                System.out.println("\nVitals Log:");
                AccessLogger.printDecryptedLog("main/logs/vitals_log.txt");
                }

                case 7 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n====== MENU ======");
        System.out.println("1. Add Patient");
        System.out.println("2. Assign Room to Patient");
        System.out.println("3. Attempt Room Access");
        System.out.println("4. Run Vital Check");
        System.out.println("5. View Patients");
        System.out.println("6. View Logs");
        System.out.println("7. Exit");
    }

    private static void addPatient() {
        String id = get("Patient ID: ");
        String name = get("Name: ");
        String record = get("Medical Record ID: ");
        patients.put(id, new Patient(id, name, record));
        System.out.println("✅ Patient added.");
    }

    private static void assignRoom() {
        String patientId = get("Enter Patient ID: ");
        Patient patient = patients.get(patientId);
        if (patient == null) {
            System.out.println("❌ Patient not found.");
            return;
        }

        System.out.println("Available Rooms: " + rooms.keySet());
        String roomId = get("Assign to Room ID: ");
        if (!rooms.containsKey(roomId)) {
            System.out.println("❌ Room not found.");
            return;
        }

        patient.setCurrentRoomId(roomId);
        System.out.println("✅ Room assigned.");
    }

    private static void accessRoom() {
        String patientId = get("Enter Patient ID: ");
        Patient patient = patients.get(patientId);
        if (patient == null) {
            System.out.println("❌ Patient not found.");
            return;
        }

        System.out.println("Available Rooms: " + rooms.keySet());
        String roomId = get("Try access to Room ID: ");
        Room room = rooms.get(roomId);

        if (room == null) {
            System.out.println("❌ Room not found.");
            return;
        }

        boolean allowed = patient.requestAccess(room);
        System.out.println("🔐 Access " + (allowed ? "GRANTED" : "DENIED"));
        AccessLogger.logAccess(patientId, roomId, allowed);
    }
    
    private static void viewPatients() {
       if (patients.isEmpty()) {
        System.out.println("No patients found.");
        return;
    }

    System.out.println("\n====== Patient List ======");
    for (Patient p : patients.values()) {
        System.out.println("ID: " + p.getId());
        System.out.println("Name: " + p.getName());
        System.out.println("Room ID: " + (p.getCurrentRoomId() != null ? p.getCurrentRoomId() : "Unassigned"));
        System.out.println("Condition: " + p.getCondition());
        VitalSigns v = p.getCurrentVitals();
        if (v != null) {
            System.out.println("Vitals: Temp: " + v.getTemperature() +
                               "°C, HR: " + v.getHeartRate() +
                               " BPM, SpO2: " + v.getOxygenLevel() + "%");
        } else {
            System.out.println("Vitals: Not recorded yet");
        }
        System.out.println("----------------------------");
    }
}

    private static void runVitalsCheck() {
        String patientId = get("Enter Patient ID: ");
        Patient patient = patients.get(patientId);
        if (patient == null) {
            System.out.println("❌ Patient not found.");
            return;
        }

        VitalMonitor monitor = new VitalMonitor();
        monitor.addSensor(new TemperatureSensor());
        monitor.addSensor(new HeartRateSensor());
        monitor.addSensor(new OxygenSensor());

        VitalSigns vitals = monitor.getVitalsSnapshot();
        patient.updateVitals(vitals);
        System.out.println("🩺 Vitals updated: " + vitals);
        AccessLogger.logVitals(patientId, vitals);
    }

    // Utility methods
    private static String get(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    private static int getInt(String msg) {
        while (true) {
            try {
                return Integer.parseInt(get(msg));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}

