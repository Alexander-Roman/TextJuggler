package com.epam.textjuggler.data;

import com.epam.textjuggler.exception.DataException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class ConsoleTextProvider implements TextProvider {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String getString() {
        @SuppressWarnings("resources")
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();

        LOGGER.log(Level.INFO, "Enter text line by line or leave blank to finish typing:");
        String input = scanner.nextLine();
        stringBuilder.append(input);

        do {
            input = scanner.nextLine();
            if (!input.equals("")) {
                stringBuilder
                        .append("\n")
                        .append(input);
            }
        } while (!input.equals(""));

        LOGGER.log(Level.INFO, "Input completed!");
        return stringBuilder.toString();
    }
}
