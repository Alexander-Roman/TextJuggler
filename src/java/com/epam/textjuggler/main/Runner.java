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
import com.epam.textjuggler.exception.DataException;
import com.epam.textjuggler.logic.TextProcessor;
import com.epam.textjuggler.logic.TextProcessorFactory;
import com.epam.textjuggler.view.TextOutput;
import com.epam.textjuggler.view.TextOutputFactory;

public class Runner {

    public static void main(String[] args) throws DataException {

        //String inputTypeValue = args[0];
        String inputTypeValue = "FILE";

        InputType inputType = InputType.valueOf(inputTypeValue);
        TextProvider textProvider = TextProviderFactory.createTextProviderByInputType(inputType);
        String text = textProvider.getString();

        TextOutputFactory textOutputFactory = new TextOutputFactory();
        TextOutput textOutput = textOutputFactory.createTextOutput();
        textOutput.displayText(text);

        //int k = Integer.parseInt(args[1]);
        int k = 6;
        //char replacement = args[2].charAt(0);
        char replacement = '_';

        TextProcessorFactory textProcessorFactory = new TextProcessorFactory();
        TextProcessor processor = textProcessorFactory.createTextProcessor();
        text = processor.replaceCharInEveryWord(text, k, replacement);

        textOutput.displayText(text);

    }
}
