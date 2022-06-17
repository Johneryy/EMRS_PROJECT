import Exceptions.EmailNotFoundException;
import Exceptions.MedicalTestNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private static int id = 1;
    private final ArrayList<Doctor> doctors = new ArrayList<>();
    private final List<MedicalTest> tests = new ArrayList<>();
    private final List<User> users = new ArrayList<>();
    private int hospitalID;
    private String name;
    private String location;

    public Hospital(String name, String location) {
        this.hospitalID = id++;
        this.name = name;
        this.location = location;
    }

    public List<MedicalTest> getTest() {
        return tests;
    }

    public void addTest(MedicalTest test) {
        tests.add(test);
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
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

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public User getAUser(String email, String password) throws EmailNotFoundException {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                if (user.iSPassword(password)) {
                    return user;
                }
            }
        }
        throw new EmailNotFoundException("email not found");
    }

    public MedicalTest getATest(int testId) {
        for (MedicalTest test : tests) {
            if (test.getTestId() == testId) {
                return test;
            }
        }
        throw new MedicalTestNotFoundException("Test not found");
    }
}
