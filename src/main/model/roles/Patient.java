package main.model.roles;

import main.model.room.Room;
import main.model.monitor.VitalMonitor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import main.model.monitor.VitalSigns;

public class Patient extends Person {
    private String medicalRecordId;
    private String currentRoomId;
    private String condition;
    private LocalDateTime admissionDate;
    private List<VitalSigns> vitalHistory;
    private VitalSigns currentVitals;

    public Patient(String id, String name, String medicalRecordId) {
        super(id, name, "Patient", 2);
        this.medicalRecordId = medicalRecordId;
        this.admissionDate = LocalDateTime.now();
        this.vitalHistory = new ArrayList<>();
        this.condition = "Stable";
    }

    @Override
    public boolean requestAccess(Room room) {
        // Patients can only access their assigned room or general areas
        return room.getRoomId().equals(currentRoomId) || 
               room.getRoomType().equals("Ward");
    }

    public void updateVitals(VitalSigns vitals) {
        this.currentVitals = vitals;
        this.vitalHistory.add(vitals);
    }

    // Getters and setters
    public String getMedicalRecordId() { return medicalRecordId; }
    public String getCurrentRoomId() { return currentRoomId; }
    public void setCurrentRoomId(String currentRoomId) { this.currentRoomId = currentRoomId; }
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
    public LocalDateTime getAdmissionDate() { return admissionDate; }
    public List<VitalSigns> getVitalHistory() { return vitalHistory; }
    public VitalSigns getCurrentVitals() { return currentVitals; }
}
