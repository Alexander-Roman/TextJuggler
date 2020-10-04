package com.epam.textjuggler.data;

import com.epam.textjuggler.exception.DataException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileTextProvider implements TextProvider {

    private final String fileName;

    public FileTextProvider(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getString() throws DataException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName))) {
            byte[] buffer = bufferedInputStream.readAllBytes();
            return new String(buffer);
        } catch (IOException e) {
            throw new DataException("File reading problem", e);
        }
    }
}
