package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.factory.RoomFactory;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.model.*;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {
    @Autowired
    private  UserService userService;

    private static User user;
    private static Room room;
    @Test
    @Order(0)
    void setUp() {
        room = RoomFactory.buildRoom("210",2,new Residence.ResidenceBuilder().setResidenceName("New Market Junctions").setGenderRestriction(GenderRestriction.ANY).build());
        user = UserFactory.buildUser("Thabo", "Tshabalala","0788578803","roomzaConnect@gmail.com","roomza", LocalDate.of(2003, Month.SEPTEMBER,3), Gender.MALE,room);
    }

    @Test
    @Order(1)
    void create() {

        User createdUser = userService.create(user);
        assertNotNull(createdUser);
        System.out.println(createdUser);
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}