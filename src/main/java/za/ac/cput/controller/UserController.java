package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.model.Room;
import za.ac.cput.model.User;
import za.ac.cput.service.ResidenceService;
import za.ac.cput.service.RoomService;
import za.ac.cput.service.UserService;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    private final RoomService roomService;
    private final ResidenceService residenceService;

    @Autowired
    public UserController(UserService userService, RoomService roomService, ResidenceService residenceService) {
        this.userService = userService;
        this.roomService = roomService;
        this.residenceService = residenceService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.create(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.update(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("delete/{userId}")
    public ResponseEntity<Boolean> deleteUser(@RequestBody User user) {
        boolean deletedCustomer = userService.delete(user.getUserId());
        return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);

    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
       List<User> userList = userService.getAll();
       return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}

