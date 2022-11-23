package org.globantBank.tests;

import io.restassured.response.Response;
import org.globantBank.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.globantBank.reporting.Reporter.info;

public class GettingTest extends BaseTest {

    @Test
    public void getUser() {
        info("Getting clients");

        Response response = basicGetRequest();

        response.prettyPrint();

        info("Validate there are not email duplicates");
        Assert.assertTrue(haveEmailDuplicates(response), "There are email duplicates");
    }
}
