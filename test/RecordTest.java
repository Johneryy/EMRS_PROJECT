import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordTest {
    Record record;

    @BeforeEach
    void setUp() {
        Hospital hospital = new Hospital("Red life","Yaba");
        Doctor doctor = new Doctor("Raman","Fashola",Gender.MALE,35);
        MedicalTest test = new MedicalTest("HIV test");
        record = new Record(hospital,doctor);
        record.addTests(test);
    }
    @Test
    void addTests() {

    }

    @Test
    void getTests() {
        MedicalTest test2 = new MedicalTest("Aids");
        record.addTests(test2);
        assertEquals("Aids",record.getMedicalTests().get(1).getTestName());
    }



    @Test
    void getHospital() {
    }

    @Test
    void setHospital() {
    }

    @Test
    void getDoctor() {
    }

    @Test
    void setDoctor() {
    }

    @Test
    void getRecordId() {
    }

    @Test
    void getMedicalTests() {
    }

    @Test
    void getBloodGroup() {
    }

    @Test
    void setBloodGroup() {
    }

    @Test
    void getGenotype() {
    }

    @Test
    void setGenotype() {
    }
}