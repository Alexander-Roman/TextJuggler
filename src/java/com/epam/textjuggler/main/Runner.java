/*
 * Task 5
 * Выполнить и через методы строковых типов, и как работа с символьной строкой и через регулярные выражения.
 * Программа обработки текста, который может быть получен как с консоли, так и с файла.
 *
 * 1. В каждом слове k-ю букву заменить заданным символом. Если k больше длины слова, корректировку не выполнять.
 */
package com.epam.textjuggler.main;

import com.epam.textjuggler.data.InputType;
import com.epam.textjuggler.data.TextProvider;
import com.epam.textjuggler.data.TextProviderFactory;
import com.epam.textjuggler.data.TextProviderFactoryCreator;
import com.epam.textjuggler.exception.DataException;
import com.epam.textjuggler.logic.ProcessorType;
import com.epam.textjuggler.logic.TextProcessor;
import com.epam.textjuggler.logic.TextProcessorFactory;
import com.epam.textjuggler.view.OutputType;
import com.epam.textjuggler.view.TextOutput;
import com.epam.textjuggler.view.TextOutputFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final InputType INPUT_TYPE = InputType.FILE;
    private static final OutputType OUTPUT_TYPE = OutputType.CONSOLE;
    private static final ProcessorType PROCESSOR_TYPE = ProcessorType.CHAR_SEQUENCE;
    private static final int ORDER_NUMBER_K = 6;
    private static final char REPLACEMENT_CHAR = '_';

    public static void main(String[] args) {

        try {
            process();
        } catch (DataException e) {
            LOGGER.log(Level.ERROR, e.getMessage(), e);
        }

    }

    private static void process() throws DataException {

        TextProviderFactory textProviderFactory = TextProviderFactoryCreator.createTextProviderFactoryByInputType(INPUT_TYPE);
        TextProvider textProvider = textProviderFactory.create();
        String text = textProvider.getString();

        TextOutput textOutput = TextOutputFactory.createTextOutputByOutputType(OUTPUT_TYPE);
        LOGGER.log(Level.INFO, "Before changes:");
        textOutput.displayText(text);

        TextProcessor processor = TextProcessorFactory.createTextProcessorByType(PROCESSOR_TYPE);
        text = processor.replaceCharInEveryWord(text, ORDER_NUMBER_K, REPLACEMENT_CHAR);

        LOGGER.log(Level.INFO, "After changes:");
        textOutput.displayText(text);
    }
}
