package org.globantBank;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GettingTest extends BaseTest {

    @Test
    public void getUser() {
        //given().when().get(URL).then().assertThat().statusCode(201);

        Response response = given()
                .contentType("application/json")
                .when()
                .get(URL);

        response.then().extract().response();

        response.prettyPrint();

        System.out.println(response.jsonPath());
    }
}
