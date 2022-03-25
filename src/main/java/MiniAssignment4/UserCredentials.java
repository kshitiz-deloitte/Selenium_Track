package MiniAssignment4;

import java.io.*;

public class UserCredentials {

    private static String username;
    private static String password;

    public UserCredentials() throws FileNotFoundException {
        FileHandler fileHandler = new FileHandler("user_credentials.csv");
        String [] data = fileHandler.getData();
        username = data[0];
        password = data[1];
    }

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
