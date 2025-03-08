package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.model.Gender;
import za.ac.cput.model.Room;
import za.ac.cput.model.User;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomFactoryTest {

    private  Room room ;
    private List<User> user ;
    @Test

    void buildRoom() {
        room = RoomFactory.buildRoom("A210",2);
        assertNotNull(room);
        assertEquals("A210",room.getRoomNumber());
    }

    @Test
    void buildRoomWithInvalidCapacity() {
        room = RoomFactory.buildRoom("A210",0);
        assertNull(room);
    }
}