import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scooter.api.CourierClient;
import scooter.api.model.Courier;

public class AuthorizationCourierNotCreatedBeforeTest {
    private CourierClient courierClient;

  @Before
   public void setUp() {
       courierClient = new CourierClient();
   }

    @Test
    public void courierCanNotBeAuthorizationNotBeCreatedBefore() {
        Courier courier = Courier.getRandom();
        Response createAuthorizationResponse = courierClient.courierAuthrizationNotCreatedBefore(courier);
        Assert.assertEquals("Courier can log in without the process of creation before",404, createAuthorizationResponse.statusCode());
        Assert.assertEquals("Wrong error message", "Учетная запись не найдена", createAuthorizationResponse.jsonPath().getString("message"));
    }
}
