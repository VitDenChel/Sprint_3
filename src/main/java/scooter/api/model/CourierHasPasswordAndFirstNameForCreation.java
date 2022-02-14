package scooter.api.model;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierHasPasswordAndFirstNameForCreation {
    public String password;
    public String firstName;

    public CourierHasPasswordAndFirstNameForCreation(String password, String firstName) {
        this.password = password;
        this.firstName = firstName;
    }

    public static CourierHasPasswordAndFirstNameForCreation getRandom() {
        String password = RandomStringUtils.randomAlphabetic(10);
        String firstName = RandomStringUtils.randomAlphabetic(10);
        return new CourierHasPasswordAndFirstNameForCreation(password, firstName);
    }
}
