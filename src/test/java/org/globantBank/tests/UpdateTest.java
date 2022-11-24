package org.globantBank.tests;

import io.restassured.response.Response;
import org.globantBank.reporting.Reporter;
import org.globantBank.utils.tests.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateTest extends BaseTest {

    @Test
    public void updateClient() {

        Reporter.info("Check endpoint is not empty");


        Response response = given()
                .contentType("application/json")
                .baseUri(URL)
                .body("")
                .when()
                .put();

        response.then().extract().response();
        response.prettyPrint();

        response.then().statusCode(201);
    }
}
