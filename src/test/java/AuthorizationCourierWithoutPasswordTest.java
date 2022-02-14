import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scooter.api.CourierClient;
import scooter.api.model.Courier;
import scooter.api.model.CourierCredentials;
import scooter.api.model.CourierHasLoginForAuthorization;
import scooter.api.model.CourierWithEmptyFieldOfPassword;

public class AuthorizationCourierWithoutPasswordTest {
    private CourierClient courierClient;
    private int courierId;
    private CourierCredentials courierCredentials;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
    }

    @After
    public void tearDown() {
        courierClient.delete(courierId);
    }

    @Test
    public void courierCanNotBeAuthorizationWithoutPassword() {
        Courier courier = Courier.getRandom();
        Response createCourierResponse = courierClient.create(courier);
        Response createCourierResponseID = courierClient.login(courierCredentials.from(courier));
        int courierID = createCourierResponseID.jsonPath().getInt("id");
        Response CourierAuthorization = courierClient.courierAuthrizationWithoutPassword(CourierHasLoginForAuthorization.from(CourierWithEmptyFieldOfPassword.getRandom()));
        Assert.assertEquals("Courier can log in without a password", 400, CourierAuthorization.statusCode());
        Assert.assertEquals("Wrong error message", "Недостаточно данных для входа", CourierAuthorization.jsonPath().getString("message"));
    }
}
