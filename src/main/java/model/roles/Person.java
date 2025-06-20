package main.model.roles;
import main.model.room.Room;

public abstract class Person {
    protected String id;
    protected String name;
    protected String role;
    protected int clearanceLevel;
    
    public Person(String id, String name, String role, int clearanceLevel) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.clearanceLevel = clearanceLevel;
    }
    
    public abstract boolean requestAccess(Room room);
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getRole() {
        return role;
    }
    
    public int getClearanceLevel() {
        return clearanceLevel;
    }
}
