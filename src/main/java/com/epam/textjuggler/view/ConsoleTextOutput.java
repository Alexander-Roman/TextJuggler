package com.epam.textjuggler.view;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleTextOutput implements TextOutput {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void displayText(String text) {
        LOGGER.log(Level.INFO, "Text output:\n" + text);
    }
}
