import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scooter.api.OrderClient;
import scooter.api.model.CreateOrderData;


public class CreateOrderSerializationTest {

    private OrderClient orderClient;
    private int track;

    @Before
    public void setUp() {
        orderClient = new OrderClient();
    }
    @After
    public void tearDown () {
        orderClient.cancel(track);
    }

    @Test
    public void createOrderWithBlackColorTest() {
        CreateOrderData createOrderData = new CreateOrderData("Alex", "Petrov", "Lenina, 4 apt.2", "7", "+72501452567", 5, "2021-04-01", "Позвоните", "BLACK");
        Response orderClientCreatedResponse = orderClient.createOrderWithTwoColors(createOrderData);
        Assert.assertEquals(201, orderClientCreatedResponse.statusCode());
        int track = orderClientCreatedResponse.jsonPath().getInt("track");
        System.out.println(track);
        Response cancelOrderClientCreatedResponse = orderClient.cancel(track);
        Assert.assertEquals(200, cancelOrderClientCreatedResponse.statusCode());
    }

        @Test
        public void createOrderWithGreyColorTest() {
            CreateOrderData createOrderData = new CreateOrderData("Tanya", "Ivanova", "Lenina, 6 apt.s", "7", "+72501452567", 6, "2021-05-01", "Обязательно позвоните", "GRAY");
            Response orderClientCreatedResponse = orderClient.createOrderWithTwoColors(createOrderData);
            Assert.assertEquals(201, orderClientCreatedResponse.statusCode());
            int track = orderClientCreatedResponse.jsonPath().getInt("track");
            System.out.println(track);
            Response cancelOrderClientCreatedResponse = orderClient.cancel(track);
            Assert.assertEquals(200, cancelOrderClientCreatedResponse.statusCode());
        }

        @Test
        public void createOrderWithTwoColorsTest() {
            CreateOrderData createOrderData = new CreateOrderData("Katya", "Sidorova", "Lenina, 10 apt.s", "7", "+72501452567", 7, "2021-06-01", "Не звоните", "GRAY, BLACK");
            Response orderClientCreatedResponse = orderClient.createOrderWithTwoColors(createOrderData);
            Assert.assertEquals(201, orderClientCreatedResponse.statusCode());
            int track = orderClientCreatedResponse.jsonPath().getInt("track");
            System.out.println(track);
            Response cancelOrderClientCreatedResponse = orderClient.cancel(track);
            Assert.assertEquals(200, cancelOrderClientCreatedResponse.statusCode());

        }
        @Test
        public void createOrderNotColorsMentionTest() {
            CreateOrderData createOrderData = new CreateOrderData("Karina", "Ilynich", "Lenina, 12 apt.s", "7", "+72501452567", 3, "2021-07-01", "Без комметариев", "");
            Response orderClientCreatedResponse = orderClient.createOrderWithTwoColors(createOrderData);
            Assert.assertEquals(201, orderClientCreatedResponse.statusCode());
            int track = orderClientCreatedResponse.jsonPath().getInt("track");
            System.out.println(track);
            Response cancelOrderClientCreatedResponse = orderClient.cancel(track);
            Assert.assertEquals(200, cancelOrderClientCreatedResponse.statusCode());
        }}