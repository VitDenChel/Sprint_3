package scooter.api.model;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierWithEmptyFieldOfPassword {

    public String login;
    public String password;


    public CourierWithEmptyFieldOfPassword(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static CourierWithEmptyFieldOfPassword getRandom() {
        String login = RandomStringUtils.randomAlphabetic(10);
        String password = "";
        return new CourierWithEmptyFieldOfPassword(login, password);
    }
}
