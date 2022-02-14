import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scooter.api.OrderClient;
import scooter.api.model.ListOfOrders;

public class GetDataSheetOfCreatedOrdersTest {
    private OrderClient orderClient;

    @Before
    public void setUp() {
        orderClient = new OrderClient();
    }

    @Test
    public void checkThatAllCreatedOrdersAreReturned() {
        ListOfOrders ReturnedListOfAllCreatedOrders = orderClient.getDataListOfAllCreatedOrders();
        Assert.assertNotNull("There are not created orders in the order list", ReturnedListOfAllCreatedOrders.getOrders().size());
    }

    @Test
    public void isListOrdersReturned() {
        Response createListOfOrdersResponse = orderClient.createListOfOrders();
        Assert.assertEquals("List of created orders is not received", 200, createListOfOrdersResponse.statusCode());
    }
}

