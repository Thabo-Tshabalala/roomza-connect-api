package za.ac.cput.factory;

import za.ac.cput.model.Gender;
import za.ac.cput.model.Room;
import za.ac.cput.model.User;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class UserFactory {

   public static User buildUser(String firstName, String lastName, String phoneNumber, String email, String password, LocalDate dateOfBirth, Gender gender, Room room) {
       if(Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)|| !Helper.isValidNumber(phoneNumber) || !Helper.isvalidEmail(email) || room == null)
           return null;


       return new User.UserBuilder().setFirstName(firstName).setLastName(lastName).setPhoneNumber(phoneNumber).setEmail(email)
               .setDateOfBirth(dateOfBirth).setGender(gender).setPassword(password).setRoom(room).build();

   }

}
