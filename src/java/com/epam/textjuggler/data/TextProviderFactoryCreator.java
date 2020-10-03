package com.epam.textjuggler.data;

public class TextProviderFactoryCreator {

    public static TextProviderFactory createTextProviderFactoryByInputType(InputType inputType) {
        switch (inputType) {
            case FILE:
                return new FileTextProviderFactory();
            case CONSOLE:
                return new ConsoleTextProviderFactory();
            default:
                throw new RuntimeException(inputType + " is unknown InputType!");
        }
    }
}
