package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomFactoryTest {

    private  Room room ;
    private Residence residence ;
    @Test

    void buildRoom() {
        residence = ResidenceFactory.createResidence("New Market Junction", GenderRestriction.ANY);
        room = RoomFactory.buildRoom("A210",2,residence);
        assertNotNull(room);
        assertEquals("A210",room.getRoomNumber());
    }

    @Test
    void buildRoomWithInvalidCapacity() {
        residence = ResidenceFactory.createResidence("New Market Junction", GenderRestriction.ANY);
        room = RoomFactory.buildRoom("A210",0,residence);
        assertNull(room);
    }
}