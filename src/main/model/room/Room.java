package main.model.room;

public abstract class Room {
    protected String roomId;
    protected String roomType;
    protected RoomAccessRule accessRule;

    public Room(String roomId, String roomType) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.accessRule = new RoomAccessRule(); // default or load specific rules
    }

    public String getRoomId() {
        return roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public RoomAccessRule getAccessRule() {
        return accessRule;
    }
}
