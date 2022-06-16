import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {
    Doctor doctor;
    Doctor doctor2;
    Doctor doctor3;
    Doctor doctor4;

    @BeforeEach
    void setUp() {
        doctor = new Doctor("John","Akintolu",Gender.MALE,19);
        doctor2 = new Doctor("Micheal","Boyo",Gender.MALE,25);
        doctor3 = new Doctor("Abigail","Paul",Gender.FEMALE,20);
        doctor4 = new Doctor("Wale","Saheed",Gender.MALE,36);
    }

    @Test
    void getDoctorId() {
        assertEquals(100,doctor.getDoctorId());
        assertEquals(101,doctor2.getDoctorId());
        assertEquals(102,doctor3.getDoctorId());
        assertEquals(103,doctor4.getDoctorId());
    }
    @Test
    void getFirstName() {
        assertEquals("John",doctor.getFirstName());
        assertEquals("Micheal",doctor2.getFirstName());
        assertEquals("Abigail",doctor3.getFirstName());
        assertEquals("Wale",doctor4.getFirstName());
    }
    @Test
    void getLastName() {
        assertEquals("Akintolu",doctor.getLastName());
        assertEquals("Boyo",doctor2.getLastName());
        assertEquals("Paul",doctor3.getLastName());
        assertEquals("Saheed",doctor4.getLastName());
    }

    @Test
    void getGender() {
        assertEquals(Gender.MALE,doctor.getGender());
        assertEquals(Gender.MALE,doctor2.getGender());
        assertEquals(Gender.FEMALE,doctor3.getGender());
        assertEquals(Gender.MALE,doctor4.getGender());
    }

    @Test
    void getAge() {
        assertEquals(19,doctor.getAge());
        assertEquals(25,doctor2.getAge());
        assertEquals(20,doctor3.getAge());
        assertEquals(36,doctor4.getAge());
    }
}