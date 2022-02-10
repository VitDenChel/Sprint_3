package scooter.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import scooter.api.model.*;

import static io.restassured.RestAssured.given;

public class CourierClient extends ScooterRestClient {
    public final String PATH = BASE_URL + "courier/";


    @Step("Create courier {courier}")
    public Response create(Courier courier) {
        return given()
                .spec(getBaseSpec())
                .body(courier)
                .when()
                .post(PATH)
                .then()
                .extract().response();
    }

    @Step("Login as {courierCredentials}")
    public Response login(CourierCredentials courierCredentials) {
        return given()
                .spec(getBaseSpec())
                .and()
                .body(courierCredentials)
                .when()
                .post(PATH + "login/")
                .then()
                .extract().response();
    }

    @Step("Delete courier {courierID}")
    public Response delete(int courierID) {
        return given()
                .spec(getBaseSpec())
                .when()
                .delete(PATH + courierID)
                .then()
                .extract().response();
    }

    @Step("Create twoCouriers {courier}")
    public Response createTwoEqualCouriers(Courier courier) {
        return given()
                .spec(getBaseSpec())
                .body(courier)
                .when()
                .post(PATH)
                .then()
                .extract().response();
    }

    @Step("CreateCourierWithoutLogin {courierIncompleteData}")
    public Response createCourierWithoutLogin(CourierHasPasswordAndFirstNameForCreation courierHasPasswordAndFirstNameForCreation) {
        return given()
                .spec(getBaseSpec())
                .body(courierHasPasswordAndFirstNameForCreation)
                .when()
                .post(PATH)
                .then()
                .extract().response();
    }

    @Step("CreateCourierWithoutPassword {courierIncompleteDataOne}")
    public Response createCourierWithoutPassword(CourierHasLoginAndFirstNameForCreation courierHasLoginAndFirstNameForCreation) {
        return given()
                .spec(getBaseSpec())
                .body(courierHasLoginAndFirstNameForCreation)
                .when()
                .post(PATH)
                .then()
                .extract().response();
    }

    @Step("CourierAuthirization as {courierCredentials}")
    public Response courierAuthrization(CourierCredentials courierCredentials) {
        return given()
                .spec(getBaseSpec())
                .and()
                .body(courierCredentials)
                .when()
                .post(PATH + "login/")
                .then()
                .extract().response();
    }


    @Step("AuthirizationWithoutLogin as {courierCredentialsWithoutLogin}")
    public Response courierAuthrizationWithoutLogin(CourierHasPasswordForAuthorization courierHasPasswordForAuthorization) {
        return given()
                .spec(getBaseSpec())
                .and()
                .body(courierHasPasswordForAuthorization)
                .when()
                .post(PATH + "login/")
                .then()
                .extract().response();
    }

    @Step("AuthirizationWithoutPassword as {courierCredentialsWithoutPassword}")
    public Response courierAuthrizationWithoutPassword(CourierHasLoginForAuthorization courierHasLoginForAuthorization) {
        return given()
                .spec(getBaseSpec())
                .and()
                .body(courierHasLoginForAuthorization)
                .when()
                .post(PATH + "login/")
                .then()
                .extract().response();
    }

    @Step("courierAuthirizationNotCreatedBefore as {courier}")
    public Response courierAuthrizationNotCreatedBefore(Courier courier) {
        return given()
                .spec(getBaseSpec())
                .and()
                .body(courier)
                .when()
                .post(PATH + "login/")
                .then()
                .extract().response();
    }
}

