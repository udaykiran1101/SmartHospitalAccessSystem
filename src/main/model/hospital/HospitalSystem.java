package main.model.hospital;

import main.model.roles.Patient;
import main.model.monitor.*;
import main.model.room.*;
import main.model.utils.AccessLogger;

public class HospitalSystem {

    public static void run() {
        // Your existing logic goes here
        Room icuRoom = new ICU("ICU001");
        Room wardRoom = new Ward("WARD001");

        Patient patient = new Patient("P001", "Alice", "MR123");
        patient.setCurrentRoomId("ICU001");

        VitalMonitor monitor = new VitalMonitor();
        monitor.addSensor(new TemperatureSensor());
        monitor.addSensor(new HeartRateSensor());
        monitor.addSensor(new OxygenSensor());

        VitalSigns vitals = monitor.getVitalsSnapshot();
        patient.updateVitals(vitals);

        System.out.println("\n--- Patient Vitals ---");
        System.out.println("Patient: " + patient.getName());
        System.out.println(patient.getCurrentVitals());
        AccessLogger.logVitals(patient.getId(), patient.getCurrentVitals());

        System.out.println("\n--- Access Attempt ---");
        boolean canAccessICU = patient.requestAccess(icuRoom);
        boolean canAccessWard = patient.requestAccess(wardRoom);
        AccessLogger.logAccess(patient.getId(), icuRoom.getRoomId(), canAccessICU);
        AccessLogger.logAccess(patient.getId(), wardRoom.getRoomId(), canAccessWard);

        System.out.println("Access to ICU: " + (canAccessICU ? "GRANTED" : "DENIED"));
        System.out.println("Access to Ward: " + (canAccessWard ? "GRANTED" : "DENIED"));

        patient.setCondition(vitals.getTemperature() > 38.0 ? "Critical" : "Stable");
        System.out.println("\nPatient Condition: " + patient.getCondition());
    }
}

