package za.ac.cput.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    private long userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;

    private User(UserBuilder builder) {
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.password = builder.password;
    }

    protected User() {}

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, phoneNumber, email, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class UserBuilder{
     private long userId;
     private String firstName;
     private String lastName;
     private String phoneNumber;
     private String email;
     private String password;

     public UserBuilder setUserId(long userId){
         this.userId = userId;
         return this;
     }
     public UserBuilder setFirstName(String firstName){
         this.firstName = firstName;
         return this;
     }
     public UserBuilder setLastName(String lastName){
         this.lastName = lastName;
         return this;
     }
     public UserBuilder setPhoneNumber(String phoneNumber){
         this.phoneNumber = phoneNumber;
         return this;
     }
     public UserBuilder setEmail(String email){
         this.email = email;
         return this;
     }
     public UserBuilder setPassword(String password){
         this.password = password;
         return this;
     }

     public UserBuilder copy(User user){
         this.userId = user.userId;
         this.firstName = user.firstName;
         this.lastName = user.lastName;
         this.phoneNumber = user.phoneNumber;
         this.email = user.email;
         this.password = user.password;
         return this;
     }

     public User build(){
         return new User(this);
     }
 }
}

