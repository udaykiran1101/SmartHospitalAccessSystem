package main.model.room;
    
public class ICU extends Room {
    public ICU(String roomId) {
        super(roomId, "ICU", 2, 4); // High security level
    }

    @Override
    protected void initializeAllowedRoles() {
        allowedRoles.add("Doctor");
        allowedRoles.add("Nurse");
        allowedRoles.add("Admin");
    }
}
