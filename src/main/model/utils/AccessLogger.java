package main.model.utils;

import main.model.roles.Person;
import main.model.room.Room;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccessLogger {

    public void logAccess(Person person, Room room, boolean granted) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String log = String.format("%s - %s (%s) attempted to access %s (%s): %s",
                timestamp, person.getName(), person.getClass().getSimpleName(),
                room.getRoomId(), room.getRoomType(),
                granted ? "GRANTED" : "DENIED");
        System.out.println(log);
        // Later: write this to file or database
    }
}
