package main.model.room;

import main.model.roles.Person;

import java.util.Arrays;
import java.util.List;

public class RoomAccessRule {

    private List<String> allowedRoles;

    public RoomAccessRule() {
        // By default, let's say Doctors and Nurses allowed
        allowedRoles = Arrays.asList("Doctor", "Nurse");
    }

    public boolean isAccessAllowed(Person person, Room room) {
        String personClassName = person.getClass().getSimpleName();
        return allowedRoles.contains(personClassName);
    }

    // You can add more advanced rules here (time, patient condition, etc.)
}
