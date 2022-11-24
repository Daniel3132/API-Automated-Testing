package org.globantBank.tests;

import io.restassured.response.Response;
import org.globantBank.data.Client;
import org.globantBank.data.ClientProvider;
import org.globantBank.utils.tests.BaseTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostTest extends BaseTest {

    @Test
    public void postClient() {
        ClientProvider provider = new ClientProvider();

        List<Client> clientsToPostList = new ArrayList<>();

        clientsToPostList.add(provider.createRandomClient());
        System.out.println(clientsToPostList.get(0));


        for (Client client : clientsToPostList) {
            Response response = given()
                    .baseUri(URL)
                    .contentType("application/json")
                    .body(client)
                    .when()
                    .post();

            response.prettyPrint();
        }


    }
}
