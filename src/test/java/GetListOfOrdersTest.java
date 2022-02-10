import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scooter.api.OrderClient;
import scooter.api.model.ListOfOrders;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class GetListOfOrdersTest {

    private OrderClient orderClient;


    @Before
    public void setUp() {
        orderClient = new OrderClient();
    }

    @Test
    public void getOfListOrders() {

        orderClient.ListOfOrders();

        Assert.assertThat(ListOfOrders.class, is(not(0)));
    }

    @Test
    public void isListOrdersCreated() {
        Response createListOfOrdersResponse = orderClient.createListOfOrders();
        Assert.assertEquals(200, createListOfOrdersResponse.statusCode());
    }

}