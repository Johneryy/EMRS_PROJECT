import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {
    Doctor doctor;
    Doctor doctor2;

    @BeforeEach
    void setUp() {
        doctor = new Doctor("John","Akintolu",Gender.MALE,19);
        doctor2 = new Doctor("Mike","Boyo",Gender.MALE,25);
    }

    @Test
    void getDoctorId() {
        assertEquals(100,doctor.getDoctorId());
        assertEquals(101,doctor2.getDoctorId());
    }

    @Test
    void getFirstName() {
        assertEquals("John",doctor.getFirstName());
        assertEquals("Mike",doctor2.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Akintolu",doctor.getLastName());
        assertEquals("Boyo",doctor2.getLastName());
    }

    @Test
    void getGender() {
        assertEquals("MALE",doctor.getGender());
        assertEquals("MALE",doctor2.getGender());
    }

    @Test
    void getAge() {
        assertEquals(19,doctor.getAge());
        assertEquals(25,doctor2.getAge());
    }
}