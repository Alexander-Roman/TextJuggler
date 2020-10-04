package com.epam.textjuggler.logic;

public class CharSequenceTextProcessor implements TextProcessor {

    private static final int ASCII_FIRST_UPPERCASE = 65;
    private static final int ASCII_LAST_UPPERCASE = 90;
    private static final int ASCII_FIRST_LOWERCASE = 97;
    private static final int ASCII_LAST_LOWERCASE = 122;

    @Override
    public String replaceCharInEveryWord(String source, int k, char replacement) {
        if (k < 1) {
            return source;
        }

        char[] chars = source.toCharArray();
        int counter = 0;
        boolean replaced = false;
        for (int i = 0; i < chars.length; i++) {
            if (isWordSymbol(chars[i])) {
                counter++;
                if (counter == k && !replaced) {
                    chars[i] = replacement;
                    replaced = true;
                }
            } else {
                counter = 0;
                replaced = false;
            }
        }
        return String.valueOf(chars);
    }

    private boolean isWordSymbol(char c) {
        boolean isUppercase = ASCII_FIRST_UPPERCASE <= c && c <= ASCII_LAST_UPPERCASE;
        boolean isLowercase = ASCII_FIRST_LOWERCASE <= c && c <= ASCII_LAST_LOWERCASE;

        return isUppercase || isLowercase;
    }
}
