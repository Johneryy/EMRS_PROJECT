import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordTest {
    Record record;

    @BeforeEach
    void setUp() {
        Record.resetId();
        Hospital hospital = new Hospital("Red life", "Yaba");
        Doctor doctor = new Doctor("Raman", "Fashola", Gender.MALE, 35);

        record = new Record(hospital, doctor);

    }

    @Test
    void addTests() {
        MedicalTest test = new MedicalTest("HIV test");
        record.addTests(test);
        assertEquals(1, record.getTests().size());
    }

    @Test
    void getTests() {
        MedicalTest test = new MedicalTest("Aids");
        MedicalTest test2 = new MedicalTest("krokro");
        record.addTests(test);
        record.addTests(test2);
        assertEquals("Aids", record.getTests().get(0).getTestName());
        assertEquals("krokro", record.getTests().get(1).getTestName());

    }

    @Test
    void getHospital() {
        assertEquals("Red life", record.getHospital().getName());
    }

    @Test
    void getDoctor() {
        assertEquals("Raman", record.getDoctor().getFirstName());
    }


    @Test
    void getRecordId() {
        assertEquals(1, record.getRecordId());
    }


    @Test
    void setBloodGroup() {
        record.setBloodGroup(BloodGroup.O_Positive);
        assertEquals("O_Positive", record.getBloodGroup());
    }

    @Test
    void getGenotype() {
        record.setGenotype(Genotype.AA);
        assertEquals("AA", record.getGenotype());
    }


}