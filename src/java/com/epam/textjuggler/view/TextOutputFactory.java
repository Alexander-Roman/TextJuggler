package com.epam.textjuggler.view;

public class TextOutputFactory {

    public static TextOutput createTextOutputByOutputType(OutputType outputType) {
        switch (outputType) {
            case CONSOLE:
                return new ConsoleTextOutput();
            default:
                throw new RuntimeException(outputType + " is unknown OutputType!");
        }
    }
}
