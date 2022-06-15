import java.util.ArrayList;

public class Record {
    private final ArrayList<MedicalTest> medicalTests = new ArrayList<>();
    Hospital hospital;
    Doctor doctor;

    public Record(Hospital hospital, Doctor doctor) {
        this.hospital = hospital;
        this.doctor = doctor;
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
}
