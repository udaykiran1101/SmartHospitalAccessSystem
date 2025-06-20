package main.model.room;

public class Ward extends Room {
    public Ward(String roomId) {
        super(roomId, "Ward", 10, 2); // Lower security level
    }

    @Override
    protected void initializeAllowedRoles() {
        allowedRoles.add("Doctor");
        allowedRoles.add("Nurse");
        allowedRoles.add("Visitor");
        allowedRoles.add("Admin");
    }
}
