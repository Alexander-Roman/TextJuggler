package com.epam.textjuggler.data;

import com.epam.textjuggler.exception.DataException;

public interface TextProvider {

    String getString() throws DataException;
}
