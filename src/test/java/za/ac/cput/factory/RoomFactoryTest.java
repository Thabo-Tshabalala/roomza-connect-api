package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.model.Room;
import za.ac.cput.model.User;

import static org.junit.jupiter.api.Assertions.*;

class RoomFactoryTest {

    private  Room room ;
    private User user ;
    @Test

    void buildRoom() {
         user = UserFactory.buildUser("Thabo", "Tshabalala","0788578803","roomzaConnect@gmail.com","roomza");
        room = RoomFactory.buildRoom(user,"A210",2);
        assertNotNull(room);
        assertEquals("A210",room.getRoomNumber());
    }

    @Test
    void buildRoomWithFail_InvalidCapacity() {
        user = UserFactory.buildUser("Thabo", "Tshabalala","0788578803","roomzaConnect@gmail.com","roomza");
        room = RoomFactory.buildRoom(user,"A210",0);
        assertNull(room);
    }
}