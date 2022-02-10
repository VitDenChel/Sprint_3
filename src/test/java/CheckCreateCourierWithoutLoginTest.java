import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scooter.api.CourierClient;
import scooter.api.model.CourierHasPasswordAndFirstNameForCreation;

public class CheckCreateCourierWithoutLoginTest {
    private CourierClient courierClient;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
    }

    @Test
    public void courierCanNotBeCreatedWithoutLogin() {

        CourierHasPasswordAndFirstNameForCreation courierIncompleteData = CourierHasPasswordAndFirstNameForCreation.getRandom();
        Response createCourierResponse = courierClient.createCourierWithoutLogin(courierIncompleteData);
        Assert.assertEquals(400, createCourierResponse.statusCode());
        Assert.assertEquals("Недостаточно данных для создания учетной записи", createCourierResponse.jsonPath().getString("message"));


    }
}