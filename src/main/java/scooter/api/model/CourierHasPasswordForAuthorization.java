package scooter.api.model;

public class CourierHasPasswordForAuthorization {

    public String password;

    public CourierHasPasswordForAuthorization(String password) {
        this.password = password;
    }
    public static CourierHasPasswordForAuthorization from(Courier courier) {
        return  new CourierHasPasswordForAuthorization(courier.password);
    }

}
