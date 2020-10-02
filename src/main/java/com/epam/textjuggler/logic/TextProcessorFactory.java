package com.epam.textjuggler.logic;

public class TextProcessorFactory {

    public TextProcessor createTextProcessor() {
        return new CharSequenceTextProcessor();
    }
}
