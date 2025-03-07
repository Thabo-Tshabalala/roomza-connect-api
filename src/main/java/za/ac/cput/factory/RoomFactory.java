package za.ac.cput.factory;
import za.ac.cput.model.Room;
import za.ac.cput.model.User;
import za.ac.cput.util.Helper;

import java.util.Optional;

public class RoomFactory {

    public static Room buildRoom(User user, String roomNumber, int capacity){
        if(user== null || Helper.isNullOrEmpty(roomNumber) || Helper.isLessThan(capacity))
            return null;

   return new Room.RoomBuilder().setUser(user).setRoomNumber(roomNumber).setCapacity(capacity).build();
    }
}
