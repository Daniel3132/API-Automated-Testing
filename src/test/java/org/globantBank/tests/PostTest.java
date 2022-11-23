package org.globantBank.tests;

import io.restassured.response.Response;
import org.globantBank.utils.tests.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostTest extends BaseTest {

    @Test
    public void postClient() {

        Response response = given()
                .contentType("application/json")
                .baseUri(URL)
                .basePath("/clients")
                .when()
                .post(URL);

        response.then().extract().response();
        response.prettyPrint();

        response.then().statusCode(201);
    }
}
