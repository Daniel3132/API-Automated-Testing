package org.globantBank.tests;

import io.restassured.response.Response;
import org.globantBank.utils.tests.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GettingTest extends BaseTest {

    @Test
    public void getUser() {
        //given().when().get(URL).then().assertThat().statusCode(201);

        Response response = given()
                .contentType("application/json")
                .when()
                .get(URL);

        response.prettyPrint();

    }
}
