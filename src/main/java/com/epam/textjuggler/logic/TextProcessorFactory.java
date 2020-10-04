package com.epam.textjuggler.logic;

public class TextProcessorFactory {

    public static TextProcessor createTextProcessorByType(ProcessorType processorType) {
        switch (processorType) {
            case REG_EX:
                return new RegExTextProcessor();
            case STRING:
                return new StringTextProcessor();
            case CHAR_SEQUENCE:
                return new CharSequenceTextProcessor();
            default:
                throw new RuntimeException(processorType + " is unknown ProcessorType!");
        }
    }
}
