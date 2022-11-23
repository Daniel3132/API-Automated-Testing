package org.globantBank.tests;

import io.restassured.response.Response;
import org.globantBank.data.Client;
import org.globantBank.utils.tests.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateTest extends BaseTest {

    @Test
    public void updateClient() {
        //It should be created as a Client Object


        Response response = given()
                .contentType("application/json")
                .body("")
                .when()
                .put(URL);

        response.then().extract().response();
        response.prettyPrint();

        response.then().statusCode(201);
    }
}
