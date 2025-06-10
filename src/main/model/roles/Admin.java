package main.model.roles;

import main.model.room.Room;

public class Admin extends Person {
    private String department;

    public Admin(String id, String name, String department) {
        super(id, name, "Admin", 5);
        this.department = department;
    }

    @Override
    public boolean requestAccess(Room room) {
        return room.isAccessAllowed(this.role, this.clearanceLevel);
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}
