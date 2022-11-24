package org.globantBank.tests;

import io.restassured.response.Response;
import org.globantBank.data.Client;
import org.globantBank.data.ClientProvider;
import org.globantBank.reporting.Reporter;
import org.globantBank.utils.tests.BaseTest;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class PostTest extends BaseTest {

    @Test
    public void postClient() {
        ClientProvider provider = new ClientProvider();

        Reporter.info("Creating List of Clients to post");
        List<Client> clientsToPostList = provider.createRandomClientsList(10);

        Reporter.info("Posting all clients created");
        for (Client client : clientsToPostList) {
            postClientRequest(client);
        }
    }


}
