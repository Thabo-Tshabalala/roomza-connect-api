package za.ac.cput.Model;

import java.util.Objects;

public class Room {
    private long roomId;
    private User user;
    private String roomNumber;
    private int capacity;

    private Room(RoomBuilder builder) {
        this.roomId = builder.roomId;
        this.user = builder.user;
        this.roomNumber = builder.roomNumber;
        this.capacity = builder.capacity;
    }

    public long getRoomId() {
        return roomId;
    }

    public User getUser() {
        return user;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomId == room.roomId && user == room.user && capacity == room.capacity && Objects.equals(roomNumber, room.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, user, roomNumber, capacity);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", user=" + user +
                ", roomNumber='" + roomNumber + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    public static class RoomBuilder {
        private long roomId;
        private User user;
        private String roomNumber;
        private int capacity;

        public void setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public RoomBuilder copy(Room room) {
            this.roomId = room.roomId;
            this.user = room.user;
            this.roomNumber = room.roomNumber;
            this.capacity = room.capacity;
            return this;
        }

        public Room build() {
        return new Room(this);
        }
    }
}
