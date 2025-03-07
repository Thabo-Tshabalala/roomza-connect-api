package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.model.User;

import static org.junit.jupiter.api.Assertions.*;
class UserFactoryTest {

    @Test
    void buildUser() {
         User user = UserFactory.buildUser("Thabo", "Tshabalala","0788578803","roomzaConnect@gmail.com","roomza");
         assertNotNull(user);
        System.out.println(user);
    }

    @Test
    //Modify here to verify all the remaining scenarios
    void buildUserWithFail_EmptyFirstName() {
     User user = UserFactory.buildUser("", "Tshabalala","0788578803","roomzaConnect@gmail.com","roomza");
        assertNull(user);
    }
}