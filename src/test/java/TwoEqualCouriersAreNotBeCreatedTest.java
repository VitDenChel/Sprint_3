import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scooter.api.CourierClient;
import scooter.api.model.Courier;
import scooter.api.model.CourierCredentials;

public class TwoEqualCouriersAreNotBeCreatedTest {

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
    public void twoEqualCouriersCanNotBeCreatedWithValidData() {

        Courier courier = Courier.getRandom();
        Response createCourierResponse = courierClient.create(courier);
        Response createSecondCourierResponse = courierClient.create(courier);
        Assert.assertEquals(409, createSecondCourierResponse.statusCode());
        Assert.assertEquals("Этот логин уже используется.", createSecondCourierResponse.jsonPath().getString("message"));
        Response createCourierResponseID = courierClient.login(courierCredentials.from(courier));
        int courierID = createCourierResponseID.jsonPath().getInt("id");


    }


}