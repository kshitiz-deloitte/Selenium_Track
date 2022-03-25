package MiniAssignment4;

import java.io.FileNotFoundException;

public class UserDetails {
    private static String firstName;
    private static String lastName;
    private static String address;

    public UserDetails() throws FileNotFoundException {
        FileHandler fileHandler = new FileHandler("user_details.csv");
        String [] data = fileHandler.getData();
        firstName = data[0];
        lastName = data[1];
        address = data[2];
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public  String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
