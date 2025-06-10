package main.model.roles;

import main.model.room.Room;

public class Nurse extends Person {
    private String shift; // Day, Night, Evening

    public Nurse(String id, String name) {
        super(id, name, "Nurse", 4);
        this.shift = "Day";
    }

    public Nurse(String id, String name, String shift) {
        super(id, name, "Nurse", 4);
        this.shift = shift;
    }

    @Override
    public boolean requestAccess(Room room) {
        return room.isAccessAllowed(this.role, this.clearanceLevel);
    }

    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
}

