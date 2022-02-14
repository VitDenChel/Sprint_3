import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scooter.api.CourierClient;
import scooter.api.model.Courier;
import scooter.api.model.CourierCredentials;

public class CourierAuthorizationTest {
    private CourierClient courierClient;
    private Courier courier;
    private int courierId;
    private CourierCredentials courierCredentials;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
        Courier courier = Courier.getRandom();
    }

    @After
    public void tearDown() {
        courierClient.delete(courierId);
    }

    @Test
    public void courierCanBeAuthorizedWithValidData() {
        Courier courier = Courier.getRandom();
        Response createCourierResponse = courierClient.create(courier);
        Response createCourierResponseID = courierClient.login(courierCredentials.from(courier));
        int courierID = createCourierResponseID.jsonPath().getInt("id");
        Response CourierAuthorization = courierClient.courierAuthrization(CourierCredentials.from(courier));
        Assert.assertEquals("Courier is not logged in with valid data", 200, CourierAuthorization.statusCode());
    }
}
