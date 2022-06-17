import java.util.ArrayList;

public class Record {
    private static int id = 1;
    private final int recordId;
    private final ArrayList<MedicalTest> medicalTests = new ArrayList<>();
    private Hospital hospital;
    private Doctor doctor;
    private BloodGroup bloodGroup;
    private Genotype genotype;

    public Record(Hospital hospital, Doctor doctor) {
        this.hospital = hospital;
        this.doctor = doctor;
        recordId = id++;
    }

    public static void resetId() {
        id = 1;
    }



    public ArrayList<MedicalTest> getTests() {
        return medicalTests;
    }

    public void addTests(MedicalTest medicalTest) {
        medicalTests.add(medicalTest);
    }

    public Hospital getHospital() {
        return hospital;
    }


    public Doctor getDoctor() {
        return doctor;
    }

    public int getRecordId() {
        return recordId;
    }

    public String getBloodGroup() {
        return String.valueOf(bloodGroup);
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getGenotype() {
        return String.valueOf(genotype);
    }

    public void setGenotype(Genotype genotype) {
        this.genotype = genotype;
    }

    @Override
    public String toString() {

        return String.format("""
                id: %d
                Hospital: %s
                Doctor: %s %s
                """, getRecordId(), hospital.getName(), doctor.getFirstName(), doctor.getLastName());
    }
}
