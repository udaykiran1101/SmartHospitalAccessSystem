package main.app;

import main.model.roles.*;
import main.model.room.*;
import main.model.utils.AccessLogger;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Smart main Access & Monitoring System ===");

        // Example: create a doctor and ICU room
        Person doctor = new Doctor("D001", "Dr. Smith");
        Room icuRoom = new ICU("ICU-101");

        // Attempt access
        boolean accessGranted = doctor.requestAccess(icuRoom);
        System.out.println(doctor.getName() + " access to " + icuRoom.getRoomId() + ": " + (accessGranted ? "GRANTED" : "DENIED"));

        // Initialize logger and log access attempt
        AccessLogger logger = new AccessLogger();
        logger.logAccess(doctor, icuRoom, accessGranted);
        // Export logs later
    }
}
