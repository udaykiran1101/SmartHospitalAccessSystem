package main.model.roles;

import main.model.room.Room;

public abstract class Person {
    protected String id;
    protected String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract boolean requestAccess(Room room);

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
