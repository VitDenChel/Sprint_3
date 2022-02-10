package scooter.api.model;

public class CourierHasLoginForAuthorization {


    public String login;
    public  String password;


    public CourierHasLoginForAuthorization(String login, String password) {
        this.login = login;
        this.password = password;

    }

    public static CourierHasLoginForAuthorization from(CourierWithEmptyFieldOfPassword courierWithEmptyFieldOfPassword) {
        return new CourierHasLoginForAuthorization(courierWithEmptyFieldOfPassword.login, courierWithEmptyFieldOfPassword.password);
    }

}