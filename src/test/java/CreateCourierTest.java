import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scooter.api.CourierClient;
import scooter.api.model.Courier;
import scooter.api.model.CourierCredentials;

public class CreateCourierTest {
    private CourierClient courierClient;
    private CourierCredentials courierCredentials;
    private int courierID;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
    }

    @After
    public void tearDown() {
        courierClient.delete(courierID);
    }

    @Test
    public void courierCanBeCreatedWithValidData() {
        Courier courier = Courier.getRandom();
        Response createCourierResponse = courierClient.create(courier);
        Response createCourierResponseID = courierClient.login(courierCredentials.from(courier));
        int courierID = createCourierResponseID.jsonPath().getInt("id");
        Assert.assertEquals("Courier is not created with valid data", 201, createCourierResponse.statusCode());
        Assert.assertEquals("Wrong error message", "true", createCourierResponse.jsonPath().getString("ok"));
    }
}