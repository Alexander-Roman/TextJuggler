package com.epam.textjuggler.data;

public class FileTextProviderFactory implements TextProviderFactory {

    private static final String FILE_NAME = "data/TextInputSource.txt";

    @Override
    public TextProvider create() {
        return new FileTextProvider(FILE_NAME);
    }
}
