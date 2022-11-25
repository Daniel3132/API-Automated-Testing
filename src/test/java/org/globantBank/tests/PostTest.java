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

    @BeforeTest
    public void deleteInitialClients() {
        List<Client> clientsList = getClientsList();

        if (clientsList.size() > 0) {
            warn("DELETING ALL CLIENTS BEFORE POST TEST");
            deleteAll(getClientsIdList());
        }
    }

    @Test
    public void postClient() {
        ClientProvider provider = new ClientProvider();

        info("Creating List of Clients to post");
        List<Client> clientsToPostList = provider.createRandomClientsList(10);

        info("Posting all clients created");
        for (Client client : clientsToPostList) {
            postClientRequest(client);
        }
    }

}
