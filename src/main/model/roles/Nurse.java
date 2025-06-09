package main.model.roles;

import main.model.room.Room;
import main.model.room.RoomAccessRule;

public class Nurse extends Person {

    public Nurse(String id, String name) {
        super(id, name);
    }

    @Override
    public boolean requestAccess(Room room) {
        // Check access rules for Nurse role
        RoomAccessRule accessRule = room.getAccessRule();
        return accessRule.isAccessAllowed(this, room);
    }
}

