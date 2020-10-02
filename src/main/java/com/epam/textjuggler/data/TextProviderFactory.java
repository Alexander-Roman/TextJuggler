package com.epam.textjuggler.data;

public class TextProviderFactory {

    private static final String FILE_NAME = "data/TextInputSource.txt";

    public static TextProvider createTextProviderByInputType(InputType inputType) {
        switch (inputType) {
            case FILE:
                return new FileTextProvider(FILE_NAME);
            case CONSOLE:
                return new ConsoleTextProvider();
            default:
                throw new RuntimeException(inputType + " is unknown InputType!");
        }
    }
}
