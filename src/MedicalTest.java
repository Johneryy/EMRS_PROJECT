public class MedicalTest {
    private static int id = 1;
    private int testId;
    private String testName;

    public MedicalTest(String testName){
        this.testName = testName;
        testId = id++;
    }

    public static void resetId() {
        id = 1;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }
}
