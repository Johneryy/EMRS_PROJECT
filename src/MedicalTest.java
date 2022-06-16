public class MedicalTest {
    private static int id = 1;
    private int testId;
    private String testName;

    public String getComment() {
        return comment;
    }

    public void addComment(String comment) {
        this.comment = comment;
    }

    private String comment;

    public MedicalTest(String testName) {
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

    @Override
    public String toString() {
        return String.format("""
                test id: %d
                test Name: %s
                """,getTestId(),getTestName());
    }
}
