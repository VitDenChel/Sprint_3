package scooter.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import scooter.api.model.CreateOrderData;
import scooter.api.model.ListOfOrders;

import static io.restassured.RestAssured.given;


public class OrderClient extends ScooterRestClient {
    public final String PATH = BASE_URL + "courier/";


    @Step("createOrderWithTwoColors as {createOrderData}")
    public Response createOrderWithTwoColors(CreateOrderData createOrderData) {
        return given()
                .spec(getBaseSpec())
                .and()
                .body(createOrderData)
                .when()
                .post(BASE_URL + "orders/")
                .then()
                .extract().response();
    }

    @Step("Cancel order {track}")
    public Response cancel(int track) {
        return given()
                .spec(getBaseSpec())
                .when()
                .put(BASE_URL + "orders/cancel?track=" + track)
                .then()
                .extract().response();
    }

    @Step("OrderList {track}")
    public void ListOfOrders (){
        ListOfOrders listOfOrders = given()
                .spec(getBaseSpec())
                .when()
                .get(BASE_URL + "orders/")
                .body().as(ListOfOrders.class);
        System.out.println(listOfOrders.getOrders());


    }
    @Step("OrderList {track}")
    public Response createListOfOrders (){
     return given()
                .spec(getBaseSpec())
                .when()
                .get(BASE_URL + "orders/")
             .then()
             .extract().response();
}}


