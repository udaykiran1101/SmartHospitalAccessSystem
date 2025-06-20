package main.model.room;

import java.util.Set;
import java.util.HashSet;

public abstract class Room {
    protected String roomId;
    protected String roomType;
    protected int capacity;
    protected boolean occupied;
    protected Set<String> allowedRoles;
    protected int securityLevel; // 1-5, higher = more restricted

    public Room(String roomId, String roomType, int capacity, int securityLevel) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.capacity = capacity;
        this.securityLevel = securityLevel;
        this.occupied = false;
        this.allowedRoles = new HashSet<>();
        initializeAllowedRoles();
    }

    protected abstract void initializeAllowedRoles();

    public boolean isAccessAllowed(String role, int clearanceLevel) {
        return allowedRoles.contains(role) && clearanceLevel >= securityLevel;
    }

    // Getters and setters
    public String getRoomId() { return roomId; }
    public String getRoomType() { return roomType; }
    public int getCapacity() { return capacity; }
    public boolean isOccupied() { return occupied; }
    public void setOccupied(boolean occupied) { this.occupied = occupied; }
    public int getSecurityLevel() { return securityLevel; }
    public Set<String> getAllowedRoles() { return allowedRoles; }
}
