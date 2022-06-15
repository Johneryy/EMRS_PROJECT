
public class Doctor {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private static int id = 100;
    private int doctorId;



    public Doctor(String firstName, String lastName, String gender, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        doctorId = id++;
    }
    public int getDoctorId(){
        return doctorId;
    }
    
    public void setDoctorId(int id){
        doctorId = id;
    }
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }


}
