import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {
    Doctor doctor;

    @BeforeEach
    void setUp() {
        doctor = new Doctor("John","Akintolu",Gender.MALE,19);
    }

    @Test
    void getDoctorId() {
        assertEquals(100,doctor.getDoctorId());
    }
    @Test
    void getFirstName() {
        assertEquals("John",doctor.getFirstName());
    }
    @Test
    void getLastName() {
        assertEquals("Akintolu",doctor.getLastName());
    }

    @Test
    void getGender() {
        assertEquals(Gender.MALE,doctor.getGender());
    }

    @Test
    void getAge() {
        assertEquals(19,doctor.getAge());
    }
}