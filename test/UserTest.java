import Exceptions.WrongPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    @BeforeEach
    void setUp() {
        User.resetId();
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
        user.addRecord(record);
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
        assertEquals("Ife", user.getFirstName());
    }

    @Test
    void setFirstName() {
        user.setFirstName("tunde");
        assertEquals("tunde", user.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Oluwa", user.getLastName());
    }

    @Test
    void setLastName() {
        user.setLastName("macros");
        assertEquals("macros", user.getLastName());
    }

    @Test
    void getEmail() {
        assertEquals("ife@gmail.com", user.getEmail());

    }

    @Test
    void setEmail() {
        user.setEmail("fife");
        assertEquals("fife", user.getEmail());
       }

    @Test
    void setPassword() {
        user.setPassword("");
    }

    @Test
    void iSPassword() {
        assertTrue(user.iSPassword("GodIsGreat007"));
    }
}