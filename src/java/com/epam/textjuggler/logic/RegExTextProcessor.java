package com.epam.textjuggler.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTextProcessor implements TextProcessor {

    private static final String WORD_REGEX = "\\w+";

    //@Override
    private String replaceCharAt(String source, int k, char replacement) {
        if (source.length() < k) {
            return source;
        }
        k--;
        Pattern pattern = Pattern.compile("(.{" + k + "}).");
        Matcher matcher = pattern.matcher(source);
        String s = String.valueOf(replacement);
        return matcher.replaceFirst(matchResult -> matchResult.group(1).concat(s));
    }

    @Override
    public String replaceCharInEveryWord(String source, int k, char replacement) {
        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = pattern.matcher(source);

        return matcher.replaceAll(matchResult -> replaceCharAt(matchResult.group(), k, replacement));
    }
}
