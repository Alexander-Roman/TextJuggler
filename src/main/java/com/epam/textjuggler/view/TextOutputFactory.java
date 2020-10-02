package com.epam.textjuggler.view;

public class TextOutputFactory {

    public TextOutput createTextOutput() {
        return new ConsoleTextOutput();
    }
}
