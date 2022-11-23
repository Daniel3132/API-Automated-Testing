package org.globantBank.tests;

import org.globantBank.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.globantBank.reporting.Reporter.*;


public class DeleteTest extends BaseTest {

    @Test
    public void deleteTest() {
        info("Getting data");
        List<String> clientsList = getClientsOrIdClientsList("clients");

        info("Verify endpoint is empty");
        if (clientsList.size() == 0) {
            error("Checkpoint is empty");

        } else {
            info("Checkpoint is not empty.");
            info("Deleting all data");
            deleteAll(getClientsOrIdClientsList("id"));

            info("Check again for endpoint data");
            clientsList = getClientsOrIdClientsList("clients");

            info("Check endpoint is now empty");
            Assert.assertEquals(clientsList.size(), 0, "Endpoint is not empty");
        }

    }
}
