package main.model.roles;

import main.model.room.Room;

public class Visitor extends Person {
    private String patientId;
    private String relationship;

    public Visitor(String id, String name, String patientId, String relationship) {
        super(id, name, "Visitor", 1); // Lowest clearance
        this.patientId = patientId;
        this.relationship = relationship;
    }

    @Override
    public boolean requestAccess(Room room) {
        return room.isAccessAllowed(this.role, this.clearanceLevel);
    }

    public String getPatientId() { return patientId; }
    public String getRelationship() { return relationship; }
}
