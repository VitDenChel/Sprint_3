package scooter.api.model;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierHasLoginAndFirstNameForCreation {



    public String login;
    public String firstName;


    public CourierHasLoginAndFirstNameForCreation(String login, String firstName) {
        this.login = login;
        this.firstName = firstName;
    }

    public static CourierHasLoginAndFirstNameForCreation getRandom() {
        String login = RandomStringUtils.randomAlphabetic(10);
        String firstName = RandomStringUtils.randomAlphabetic(10);
        return new CourierHasLoginAndFirstNameForCreation(login, firstName);
    }
}
