package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.model.Room;
import za.ac.cput.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements IService<Room,Long> {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository repository) {
        this.roomRepository = repository;
    }

    @Override
    public Room create(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room read(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Room update(Room room) {
        if(roomRepository.existsById(room.getRoomId()))
            return roomRepository.save(room);
        throw new RuntimeException("Room not found");
    }

    @Override
    public boolean delete(Long Id) {
 if(roomRepository.findById(Id).isPresent()){
     roomRepository.deleteById(Id);
 }
 else {
     throw new IllegalStateException("Room " + Id+ " not found");
 }

        return false;
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }
    public Room getRoomById(Long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        return room.orElseThrow(() -> new IllegalArgumentException("Room with ID " + roomId + " not found"));
    }
}
