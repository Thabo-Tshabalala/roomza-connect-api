package za.ac.cput.factory;

import za.ac.cput.model.User;
import za.ac.cput.util.Helper;

import java.util.Optional;

public class UserFactory {

   public static Optional<User> buildUser(String firstName, String lastName, String phoneNumber, String email, String password) {
       if(Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)|| !Helper.isValidNumber(phoneNumber) || !Helper.isvalidEmail(email))
           return Optional.empty();


       return Optional.of(new User.UserBuilder().setFirstName(firstName).setLastName(lastName).setPhoneNumber(phoneNumber).setEmail(email.toLowerCase()).setPassword(password).build());

   }

}
