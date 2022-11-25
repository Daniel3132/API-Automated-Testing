package org.globantBank.utils;

import org.globantBank.reporting.Reporter;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Use to Write reports when Test just finished and give a more organized info
 */
public class Listener implements ITestListener {

    /**
     * Report in case Test passed
     *
     * @param result of the Test
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.info("Test: " + result.getName() + " [PASSED]");
    }

    /**
     * Report in case Test failed
     *
     * @param result of the Test
     */
    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.error("Test: " + result.getName() + " [FAILED]");
    }

}
