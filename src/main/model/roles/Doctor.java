package main.model.roles;

import main.model.room.Room;
import main.model.room.RoomAccessRule;

public class Doctor extends Person {

    public Doctor(String id, String name) {
        super(id, name);
    }

    @Override
    public boolean requestAccess(Room room) {
        // Check access rules for Doctor role
        RoomAccessRule accessRule = room.getAccessRule();
        return accessRule.isAccessAllowed(this, room);
    }
}
