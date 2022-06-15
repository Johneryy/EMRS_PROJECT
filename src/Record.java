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

    public ArrayList<MedicalTest> getTests() {
        return medicalTests;
    }

    public void addTests(MedicalTest medicalTest) {
        medicalTests.add(medicalTest);
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getRecordId() {
        return recordId;
    }

    public ArrayList<MedicalTest> getMedicalTests() {
        return medicalTests;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Genotype getGenotype() {
        return genotype;
    }

    public void setGenotype(Genotype genotype) {
        this.genotype = genotype;
    }
}
