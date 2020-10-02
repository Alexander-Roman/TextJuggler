package com.epam.textjuggler.logic;

public class CharSequenceTextProcessor implements TextProcessor {

    private static final int ASCII_FIRST_DIGIT = 48;
    private static final int ASCII_LAST_DIGIT = 48;
    private static final int ASCII_FIRST_UPPERCASE = 65;
    private static final int ASCII_LAST_UPPERCASE = 90;
    private static final int ASCII_UNDERSCORE = 95;
    private static final int ASCII_FIRST_LOWERCASE = 97;
    private static final int ASCII_LAST_LOWERCASE = 122;

    /*
    @Override
    public String replaceCharAt(String source, int k, char replacement) {
        char[] chars = source.toCharArray();
        if (chars.length < k) {
            return source;
        }
        chars[k - 1] = replacement;
        return String.valueOf(chars);
    }
    */

    @Override
    public String replaceCharInEveryWord(String source, int k, char replacement) {
        char[] chars = source.toCharArray();
        int counter = 0;
        boolean replaced = false;
        for (int i = 0; i < chars.length; i++) {
            boolean isDigit = ASCII_FIRST_DIGIT <= chars[i] && chars[i] <= ASCII_LAST_DIGIT;
            boolean isUppercase = ASCII_FIRST_UPPERCASE <= chars[i] && chars[i] <= ASCII_LAST_UPPERCASE;
            boolean isUnderscore = chars[i] == ASCII_UNDERSCORE;
            boolean isLowercase = ASCII_FIRST_LOWERCASE <= chars[i] && chars[i] <= ASCII_LAST_LOWERCASE;
            if (isDigit || isUppercase || isUnderscore || isLowercase) {
                counter++;
            } else {
                counter = 0;
                replaced = false;
            }
            if (counter == k && !replaced) {
                chars[i] = replacement;
                replaced = true;
            }
        }
        return String.valueOf(chars);
    }
}
