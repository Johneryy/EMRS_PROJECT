import java.util.ArrayList;

public class Hospital {
    private static int id = 1;
    private int hospitalID;
    private String name;
    private String location;
    private final ArrayList<Doctor> doctors = new ArrayList<>();

    public Hospital(String name, String location) {
        this.hospitalID = id++;
        this.name = name;
        this.location = location;
    }

    public int getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(int hospitalID) {
        this.hospitalID = hospitalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }
    public void addDoctor(Doctor doctor){
        doctors.add(doctor);
    }
}
