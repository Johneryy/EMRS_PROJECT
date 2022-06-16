import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicalTestTest {
    MedicalTest test;
    @BeforeEach
    void setUp() {
        MedicalTest.resetId();
        test = new MedicalTest("HIV");

    }

    @Test
    void getTestId() {
        MedicalTest test2 = new MedicalTest("Gonorrhoea");
        assertEquals(1,test.getTestId());
        assertEquals(2,test2.getTestId());
    }

    @Test
    void setTestId() {
        test.setTestId(12);
        assertEquals(12,test.getTestId());
    }

    @Test
    void getTestName() {
        assertEquals(test.getTestName(),"HIV");
    }

    @Test
    void setTestName() {
        test.setTestName("Xochipilli test");
        assertEquals("Xochipilli test",test.getTestName());
    }
}