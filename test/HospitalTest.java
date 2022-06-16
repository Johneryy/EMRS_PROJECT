import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HospitalTest {
    Hospital hospital;

    @BeforeEach
    void setUp() {
        hospital = new Hospital("koko", "sabo");
    }


    @Test
    void addTest() {
        MedicalTest test = new MedicalTest("krokro");
        hospital.addTest(test);
        assertEquals(1, hospital.getTest().size());
    }


    @Test
    void addUser() {
        User user = new User("Ife", "Oluwa", "ife@gmail.com", "GodIsGreat007");
        hospital.addUser(user);
        assertEquals(1,hospital.getUsers().size());
    }

    @Test
    void getHospitalID() {
        assertEquals(1, hospital.getHospitalID());
    }



    @Test
    void getName() {
    }

    @Test
    void setName() {
    }

    @Test
    void getLocation() {
    }

    @Test
    void setLocation() {
    }

    @Test
    void getDoctors() {
    }

    @Test
    void addDoctor() {

    }

    @Test
    void getAUser() {
    }

    @Test
    void getATest() {
    }
}