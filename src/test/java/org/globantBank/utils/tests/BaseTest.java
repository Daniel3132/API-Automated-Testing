package org.globantBank.utils.tests;

import io.restassured.response.Response;
import org.globantBank.data.Client;
import org.testng.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.globantBank.reporting.Reporter.info;

/**
 * Base for all test
 * contains all methods
 */
public class BaseTest {
    protected final String URL = "https://637cceba16c1b892ebbfbedf.mockapi.io/bank/clients";

    /**
     * Get request for clients
     *
     * @return HTTP response of getting all clients
     */
    public Response getClients() {
        info("Getting clients");
        Response response = given()
                .contentType("application/json")
                .baseUri(URL)
                .when()
                .get();

        response.prettyPrint();

        info("Check Status code for GET is 200");
        Assert.assertEquals(response.statusCode(), 200, "Status code is not expected (200)");

        return response;
    }

    /**
     * form the GET response take all clients and make a list
     *
     * @return a List of the clients in the endpoint
     */
    public List<Client> getClientsList() {
        Response response = getClients();
        return response.jsonPath().<Client>getList("");
    }

    /**
     * form the GET response take all clients and make a list with the ids
     *
     * @return a List of the clients ids
     */
    public List<String> getClientsIdList() {
        Response response = getClients();
        return response.jsonPath().<String>getList("id");
    }

    /**
     * take a list of ids and pick one randomly
     * get the chosen client and check for a correct status code
     *
     * @param list of ids
     * @return response for getting a single client
     */
    public Response getRandomClientFromList(List<String> list) {
        int index = (int) (Math.random() * list.size());
        Response response = given()
                .contentType("application/json")
                .baseUri(URL)
                .basePath("/" + list.get(index))
                .when()
                .get();

        info("Check Status code for GET request is 200");
        Assert.assertEquals(response.statusCode(), 200, "Status code is not expected (200)");

        return response;
    }

    /**
     * Do a POST request with a client body and check for a correct status code
     *
     * @param client
     */
    public void postClientRequest(Client client) {
        Response response = given()
                .baseUri(URL)
                .contentType("application/json")
                .body(client)
                .when()
                .post();

        response.prettyPrint();

        info("Check Status code for POST is 201");
        Assert.assertEquals(response.statusCode(), 201, "Status code is not expected (201)");
    }

    /**
     * Do a Put request for a client
     * used to update client data
     *
     * @param client
     */
    public void putClientRequest(Client client) {
        Response response = given()
                .contentType("application/json")
                .baseUri(URL)
                .basePath("/" + client.getId())
                .body(client)
                .when()
                .put();

        response.prettyPrint();

        info("Validate Status code for PUT request is 200");
        Assert.assertEquals(response.statusCode(), 200, "Status code is not expected (200)");
    }

    /**
     * iterates a list of ids to do a delete request
     * validating a correct status code for deleting
     *
     * @param idsList list of ids
     */
    public void deleteAll(List<String> idsList) {
        for (String clientID : idsList) {
            Response response = given()
                    .contentType("application/json")
                    .baseUri(URL)
                    .basePath(clientID)
                    .when()
                    .delete();

            String status = (response.getStatusCode() == 200) ? "Success  -  200" : "Fail  -  " + response.getStatusCode();
            info("Delete user by ID: " + clientID + "    -    " + status);
        }
    }

    /**
     * check if a list of emails have duplicates
     *
     * @param response for get clients and turn it in to emails list
     * @return boolean for have duplicates or not
     */
    public boolean haveEmailDuplicates(Response response) {
        List<String> emailsList = response.jsonPath().getList("email");
        Set<String> set = new HashSet<>(emailsList);
        return set.size() < emailsList.size();
    }

}
