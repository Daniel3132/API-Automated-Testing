package org.globantBank;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostTest extends BaseTest {

    @Test
    public void postUser() {
        //It should be created as an User Object

        Map<String, String> user = new HashMap<String, String>();
        user.put("first_name", "luisa");
        user.put("las_name", "Fernandez");
        user.put("email_name", "luisa@gmail.com");
        user.put("country_name", "Colombia");
        user.put("telephone_name", "3013547681");

        Response response = given()
                .contentType("application/json")
                .body(user)
                .when()
                .post(URL);

        response.then().extract().response();
        response.prettyPrint();

        response.then().statusCode(201);
    }
}
