package za.ac.cput.factory;
import za.ac.cput.model.Room;
import za.ac.cput.model.User;
import za.ac.cput.util.Helper;

import java.util.List;
import java.util.Optional;

public class RoomFactory {

    public static Room buildRoom(String roomNumber, int capacity){
        if( Helper.isNullOrEmpty(roomNumber) || Helper.isLessThan(capacity))
            return null;

   return new Room.RoomBuilder().setRoomNumber(roomNumber).setCapacity(capacity).build();
    }
}
