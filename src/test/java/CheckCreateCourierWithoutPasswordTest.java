import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scooter.api.CourierClient;
import scooter.api.model.CourierHasLoginAndFirstNameForCreation;

public class CheckCreateCourierWithoutPasswordTest {

    private CourierClient courierClient;
    private CourierHasLoginAndFirstNameForCreation courierHasLoginAndFirstNameForCreation;

    @Before
    public void setUp() {
        courierClient  = new CourierClient();
    }

    @Test
    public void couriersCanNotBeCreatedWithoutPassword() {

        CourierHasLoginAndFirstNameForCreation courierHasLoginAndFirstNameForCreation = CourierHasLoginAndFirstNameForCreation.getRandom();

        Response createCourierResponse = courierClient.createCourierWithoutPassword(courierHasLoginAndFirstNameForCreation);
        Assert.assertEquals(400, createCourierResponse.statusCode());
        Assert.assertEquals("Недостаточно данных для создания учетной записи", createCourierResponse.jsonPath().getString("message"));
    }


}