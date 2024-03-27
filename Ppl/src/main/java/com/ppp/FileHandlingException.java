package com.ppp;
import java.io.FileNotFoundException;

public class FileHandlingException extends Exception {
    public FileHandlingException(String message, FileNotFoundException cause) {
        super(message, cause);
    }
}