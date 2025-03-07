package za.ac.cput.Model;

import java.util.Objects;

public class User {
    private long userId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String password;

    private User(UserBuilder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.password = builder.password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, surname, phoneNumber, email, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class UserBuilder{
     private long userId;
     private String name;
     private String surname;
     private String phoneNumber;
     private String email;
     private String password;

     public UserBuilder setUserId(long userId){
         this.userId = userId;
         return this;
     }
     public UserBuilder setName(String name){
         this.name = name;
         return this;
     }
     public UserBuilder setSurname(String surname){
         this.surname = surname;
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
         this.name = user.name;
         this.surname = user.surname;
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

