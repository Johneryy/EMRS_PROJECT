import Exceptions.WrongPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    @BeforeEach
    void setUp() {
        user = new User("Ife", "Oluwa", "ife@gmail.com", "GodIsGreat007");
    }

    @Test
    void getUserId() {

        User user2 = new User("Lola", "Kiki", "kiki@gmail.com", "possiblyBull");
        assertEquals(1, user.getUserId());
        assertEquals(2, user2.getUserId());
    }

    @Test
    void getRecords() {
    }

    @Test
    void setRecords() {
        Hospital hospital = new Hospital("GoodLife","sabo");
        Doctor doctor = new Doctor("Ken","Beck",Gender.MALE,46);
        Record record = new Record(hospital,doctor);
//        user.setRecords(record);
        assertEquals(1, user.getRecords("GodIsGreat007").size());


    }
    @Test
    void WrongPasswordException() {
        WrongPasswordException thrown =assertThrows(
                WrongPasswordException.class,
                ()-> user.getRecords("5648")
                );
        assertEquals(thrown.getMessage(),"incorrect password");
    }

    @Test
    void getFirstName() {
    }

    @Test
    void setFirstName() {
    }

    @Test
    void getLastName() {
    }

    @Test
    void setLastName() {
    }

    @Test
    void getEmail() {
    }

    @Test
    void setEmail() {
    }

    @Test
    void setPassword() {
        user.setPassword("");
    }
}