package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import za.ac.cput.model.Room;
import za.ac.cput.model.User;
import za.ac.cput.service.ResidenceService;
import za.ac.cput.service.RoomService;
import za.ac.cput.service.UserService;

@Controller
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
        if (user.getRoom().getRoomId() == 0 && user.getRoom().getResidence().getResidenceId()==0)  {
            residenceService.create(user.getRoom().getResidence());
            roomService.create(user.getRoom());

        }
        User createdUser = userService.create(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
