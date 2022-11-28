package org.globantBank.reporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * To make easier the way of print messages on console log test
 */
public final class Reporter {

    public Reporter() {
    }

    /**
     * @return Logger
     */
    private static Logger getLogger() {
        return LoggerFactory.getLogger(Reporter.class);
    }

    /**
     * To print in console with info message
     *
     * @param text String to be printed
     */
    public static void info(String text) {
        getLogger().info(text);
    }

    /**
     * To print in console with error message
     *
     * @param text String to be printed
     */
    public static void error(String text) {
        getLogger().error(text);
    }

    /**
     * To print in console with warning message
     *
     * @param text String to be printed
     */
    public static void warn(String text) {
        getLogger().warn(text);
    }
}
