import Exceptions.WrongPasswordException;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static int id = 1;
    private final List<Record> records = new ArrayList<>();
    private final int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        userId = id++;
    }

    public static void resetId() {
        id = 1;
    }

    public int getUserId() {
        return userId;
    }

    public List<Record> getRecords(String password) {
        if(!this.password.equals(password)){
            throw new WrongPasswordException("incorrect password");
        }
        return records;
    }

    public void addRecord(Record record) {
        records.add(record);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean iSPassword(String password) {
        if(!this.password.equals(password)){
            throw new WrongPasswordException("wrong password");
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("""
                id: %d
                name: %s %s
                email: %s
                """,getUserId(),getFirstName(),getLastName(),getEmail());
    }
}