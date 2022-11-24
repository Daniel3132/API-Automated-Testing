package org.globantBank.utils.tests;

import io.restassured.response.Response;
import org.globantBank.data.Client;
import org.testng.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.globantBank.reporting.Reporter.info;

public class BaseTest {
    protected final String URL = "https://637cceba16c1b892ebbfbedf.mockapi.io/bank/clients";

    public Response GetClientsRequest() {
        return given()
                .contentType("application/json")
                .baseUri(URL)
                .when()
                .get();
    }

    public Response getClients(){
        info("Getting clients");
        Response response = GetClientsRequest();

        response.prettyPrint();

        info("Check Status code for GET is 200");
        Assert.assertEquals(response.statusCode(), 200, "Status code is not expected (200)");

        return response;
    }

    public List<Client> getClientsList() {
        Response response = getClients();
        return response.jsonPath().<Client>getList("");
    }

    public List<String> getClientsIdList(){
        Response response = getClients();
        return response.jsonPath().<String>getList("id");
    }

    public boolean haveEmailDuplicates(Response response) {
        List<String> emailsList = response.jsonPath().getList("Email");

        Set<String> set = new HashSet<>(emailsList);
        return !(set.size() < emailsList.size());
    }


    public void deleteAll(List<String> idsList) {
        for (String clientID : idsList) {
            Response response = given()
                    .contentType("application/json")
                    .baseUri(URL)
                    .basePath(clientID)
                    .when()
                    .delete();

            String status = (response.getStatusCode() == 200) ? "Success" : "Fail";
            info("Delete user by ID: " + clientID + "    -    " + status);
        }
    }

}
