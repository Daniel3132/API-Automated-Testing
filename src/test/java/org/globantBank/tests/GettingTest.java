package org.globantBank.tests;

import io.restassured.response.Response;
import org.globantBank.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.globantBank.reporting.Reporter.info;

public class GettingTest extends BaseTest {

    /**
     * Get a list of clients, get their emails and search for duplicates
     */
    @Test
    public void getClient() {
        info("Getting clients");
        Response response = getClients();

        info("Validate there are not email duplicates");
        Assert.assertFalse(haveEmailDuplicates(response), "There are email duplicates");
    }
}
