package org.globantBank.tests;

import org.globantBank.data.Client;
import org.globantBank.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.globantBank.reporting.Reporter.info;
import static org.globantBank.reporting.Reporter.warn;


public class DeleteTest extends BaseTest {

    /**
     * Check the endpoint is not empty to begin Deleting all data
     */
    @Test
    public void deleteTest() {
        info("Getting data");
        List<Client> clientsList = getClientsList();

        info("Verify endpoint is empty");
        if (clientsList.size() == 0) {
            warn("Checkpoint is empty");

        } else {
            info("Checkpoint is not empty.");
            info("Deleting all data");
            deleteAll(getClientsIdList());

            info("Check again for endpoint data");
            clientsList = getClientsList();

            info("Check endpoint is now empty");
            Assert.assertEquals(clientsList.size(), 0, "Endpoint is not empty");
        }
    }

}
