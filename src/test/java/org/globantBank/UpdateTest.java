package org.globantBank;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdateTest extends BaseTest {

    @Test
    public void updateUser() {
        //It should be created as a User Object
        Map<String, String> user = new HashMap<String, String>();

        user.put("first_name", "Daniel");
        user.put("las_name", "Correa");
        user.put("email", "danielcorrea@gmail.com");
        user.put("country", "Colombia");
        user.put("telephone", "3013547681");

        Response response = given()
                .contentType("application/json")
                .body(user)
                .when()
                .put(URL);

        response.then().extract().response();
        response.prettyPrint();

        response.then().statusCode(201);
    }
}
