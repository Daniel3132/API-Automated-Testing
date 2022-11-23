package org.globantBank.utils.tests;

import io.restassured.response.Response;
import org.globantBank.data.Client;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.*;
import static org.globantBank.reporting.Reporter.*;

public class BaseTest {
    protected final String URL = "https://637cceba16c1b892ebbfbedf.mockapi.io/bank/";
    Client client = new Client();

    @Test
    public void getClients() {
        Response response = given()
                .contentType("application/json")
                .baseUri(URL)
                .basePath("/clients")
                .when()
                .get();

        response.then().extract().response();
//        response.prettyPrint();

        info("Validate Status code is 200");
        Assert.assertEquals(response.statusCode(), 200, "Status code is not expected (200)");

        List<String> clientsList = response.jsonPath().getList("") ;
        System.out.println(clientsList);

        if(clientsList.size() == 0){
            warn("Endpoint is empty");
        }

        List<String> emailsList = response.jsonPath().getList("Email") ;
        System.out.println(emailsList);

        Set<String> set = new HashSet<String>(emailsList);

        if(set.size()<emailsList.size()){
            warn("There are duplicates");
        }

    }

}
