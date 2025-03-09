package za.ac.cput.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String firstName;
    private String lastName;
    @Column(length = 10)
    private String phoneNumber;
//    @Column(nullable=false, unique=true)
    private String email;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String password;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "room_id")
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    private User(UserBuilder builder) {
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.dateOfBirth = builder.dateOfBirth;
        this.gender = builder.gender;
        this.password = builder.password;
        this.room = builder.room;
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

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }



    public long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(email, user.email) && Objects.equals(dateOfBirth, user.dateOfBirth) && gender == user.gender && Objects.equals(password, user.password) && Objects.equals(room, user.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, phoneNumber, email, dateOfBirth, gender, password, room);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", password='" + password + '\'' +
                ", room=" + room +
                '}';
    }

    public static class UserBuilder{
     private long userId;
     private String firstName;
     private String lastName;
        private String phoneNumber;
     private String email;
     private LocalDate dateOfBirth;
     private Gender gender;
     private String password;
     private Room room;


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

        public UserBuilder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public UserBuilder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder setPassword(String password){
         this.password = password;
         return this;
     }
     public UserBuilder setRoom(Room room){
         this.room = room;
         return this;
     }

     public UserBuilder copy(User user){
         this.userId = user.userId;
         this.firstName = user.firstName;
         this.lastName = user.lastName;
         this.email = user.email;
         this.phoneNumber = user.phoneNumber;
         this.dateOfBirth = user.dateOfBirth;
         this.gender = user.gender;
         this.password = user.password;
         this.room = user.room;
         return this;
     }

     public User build(){
         return new User(this);
     }
 }
}

