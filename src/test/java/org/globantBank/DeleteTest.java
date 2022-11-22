package org.globantBank;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteTest extends BaseTest {

    @Test
    public void deleteUser() {
        Response response = given()
                .contentType("application/json")
                .when()
                .delete(URL);

        response.then().extract().response();
        response.prettyPrint();

        response.then().statusCode(200);
    }
}
