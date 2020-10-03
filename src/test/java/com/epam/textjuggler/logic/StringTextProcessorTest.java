package com.epam.textjuggler.logic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringTextProcessorTest {

    private static final String TEST_STRING = "The rules in this book do not apply 100 percent of the time";
    private static final String EMPTY_STRING = "";
    private final StringTextProcessor processor = new StringTextProcessor();

    @Test
    public void replaceCharInEveryWordTestShouldReplaceOneCharInWordsOnly() {
        //given
        int target = 3;
        char replacement = '_';
        //when
        String actual = processor.replaceCharInEveryWord(TEST_STRING, target, replacement);
        //then
        String expected = "Th_ ru_es in th_s bo_k do no_ ap_ly 100 pe_cent of th_ ti_e";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void replaceCharInEveryWordTestShouldDoNotingIfTargetCharNumberLessThenOne() {
        //given
        int target = 0;
        char replacement = '_';
        //when
        String actual = processor.replaceCharInEveryWord(TEST_STRING, target, replacement);
        //then
        Assert.assertEquals(actual, TEST_STRING);
    }

    @Test
    public void replaceCharInEveryWordTestShouldReturnNotNull() {
        //given
        int target = 3;
        char replacement = '_';
        //when
        String actual = processor.replaceCharInEveryWord(EMPTY_STRING, target, replacement);
        //then
        Assert.assertNotNull(actual);
    }
}
