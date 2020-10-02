package com.epam.textjuggler.logic;

public class StringTextProcessor implements TextProcessor {

    private static final String WORD_SEPARATOR = "\\W";

    @Override
    public String replaceCharInEveryWord(String source, int k, char replacement) {
        String[] words = source.split(WORD_SEPARATOR);
        String result = source;
        for (String word : words) {
            String replacementString = replaceCharAt(word, k, replacement);
            result = result.replace(word, replacementString);
        }
        return result;
    }

    private String replaceCharAt(String source, int k, char replacement) {
        if (source.length() < k) {
            return source;
        }
        String result = source.substring(0, k - 1);
        String replacementString = String.valueOf(replacement);
        result = result.concat(replacementString);
        if (source.length() > k) {
            String ending = source.substring(k);
            result = result.concat(ending);
        }
        return result;
    }
}
