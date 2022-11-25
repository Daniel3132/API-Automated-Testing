package org.globantBank.tests;

import org.globantBank.data.Client;
import org.globantBank.data.ClientProvider;
import org.globantBank.utils.tests.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.globantBank.reporting.Reporter.info;
import static org.globantBank.reporting.Reporter.warn;

public class PostTest extends BaseTest {

    /**
     * Check if there are any register to delete before start posting
     * Used to avoid duplicate emails error in other tests
     */
    @BeforeTest
    public void deleteInitialClients() {
        List<Client> clientsList = getClientsList();

        if (clientsList.size() > 0) {
            warn("DELETING ALL CLIENTS BEFORE POST TEST");
            deleteAll(getClientsIdList());
        }
    }


    /**
     * Create 10 random clients ensuring there are not email duplicates
     * and post all the clients for the list checking a correct status code
     */
    @Test
    public void postClient() {
        int wishedRandomClients = 10;
        ClientProvider provider = new ClientProvider();

        info("Creating List of Clients to post");
        List<Client> clientsToPostList = provider.createRandomClientsList(wishedRandomClients);

        info("Posting all clients created");
        for (Client client : clientsToPostList) {
            postClientRequest(client);
        }
    }

}
