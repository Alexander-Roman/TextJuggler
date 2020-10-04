package com.epam.textjuggler.data;

public class ConsoleTextProviderFactory implements TextProviderFactory {

    @Override
    public TextProvider create() {
        return new ConsoleTextProvider();
    }
}
