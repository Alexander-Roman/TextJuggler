package com.epam.textjuggler.data;

import com.epam.textjuggler.exception.DataException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FileTextProviderTest {

    private static final String FILE_CORRECT = "src/test/resources/TextInputSourceTest.txt";
    private static final String FILE_EMPTY = "src/test/resources/TextInputSourceTestEmpty.txt";
    private static final String FILE_LOST = "src/test/resources/TextInputSourceTestLost.txt";

    @Test
    public void getStringTestShouldReturnCorrectStringFromFile() throws DataException {
        //given
        FileTextProvider provider = new FileTextProvider(FILE_CORRECT);
        //when
        String actual = provider.getString();
        //then
        String expected = "Test text with" + System.lineSeparator() + "line break";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getStringTestShouldReturnEmptyStringFromEmptyFile() throws DataException {
        //given
        FileTextProvider provider = new FileTextProvider(FILE_EMPTY);
        //when
        String actual = provider.getString();
        //then
        String expected = "";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getStringTestShouldReturnNotNull() throws DataException {
        //given
        FileTextProvider provider = new FileTextProvider(FILE_EMPTY);
        //when
        String actual = provider.getString();
        //then
        Assert.assertNotNull(actual);
    }

    @Test(expectedExceptions = DataException.class)
    public void getStringTestShouldThrowDataExceptionWhenFileLost() throws DataException {
        //given
        FileTextProvider provider = new FileTextProvider(FILE_LOST);
        //when
        String actual = provider.getString();
    }


}
