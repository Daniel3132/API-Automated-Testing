package org.globantBank.tests;

import io.restassured.response.Response;
import org.globantBank.data.Client;
import org.globantBank.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.globantBank.reporting.Reporter.info;

public class UpdateTest extends BaseTest {

    @Test
    public void updateClient() {
        List<String> clientsIdList = getClientsIdList();

        info("Check endpoint is not empty");
        Assert.assertTrue(clientsIdList.size() > 0, "There are not clients.");

        info("Getting random client to update");
        Response responseGET = getRandomClientFromList(clientsIdList);

        info("Setting new account number");
        Client clientToUpdate = responseGET.jsonPath().getObject("", org.globantBank.data.Client.class);
        clientToUpdate.setAccountNumber(100000000);

        info("Request to update client with id: " + clientToUpdate.getId() + " with new account number: " + clientToUpdate.getAccountNumber());
        putClientRequest(clientToUpdate);
    }
}
