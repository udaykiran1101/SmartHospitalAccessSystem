package main.model.roles;

import main.model.room.Room;

public class Doctor extends Person {
    private String specialization;
    private String department;

    public Doctor(String id, String name) {
        super(id, name, "Doctor", 5); // Highest clearance level
        this.specialization = "General Medicine";
        this.department = "General";
    }

    public Doctor(String id, String name, String specialization, String department) {
        super(id, name, "Doctor", 5);
        this.specialization = specialization;
        this.department = department;
    }

    @Override
    public boolean requestAccess(Room room) {
        return room.isAccessAllowed(this.role, this.clearanceLevel);
    }

    // Getters and setters
    public String getSpecialization() { return specialization; }
    public String getDepartment() { return department; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public void setDepartment(String department) { this.department = department; }
}
