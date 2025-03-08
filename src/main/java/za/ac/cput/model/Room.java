package za.ac.cput.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
@Entity

@Table(name="rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    private long roomId;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<User> user;
    private String roomNumber;
    private int capacity;

    private Room(RoomBuilder builder) {
        this.roomId = builder.roomId;
        this.user = builder.user;
        this.roomNumber = builder.roomNumber;
        this.capacity = builder.capacity;
    }

    protected Room() {}

    public long getRoomId() {
        return roomId;
    }

    public List<User> getUser() {
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
        return roomId == room.roomId && capacity == room.capacity && Objects.equals(user, room.user) && Objects.equals(roomNumber, room.roomNumber);
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
        private List<User> user;
        private String roomNumber;
        private int capacity;

        public RoomBuilder setUser(List<User> user) {
            this.user = user;
           return this;
        }

        public RoomBuilder setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public RoomBuilder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
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
