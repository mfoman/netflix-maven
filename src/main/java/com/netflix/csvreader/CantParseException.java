package com.netflix.csvreader;

public class CantParseException extends RuntimeException {
    public CantParseException(String message) {
        super(message);
    }
}
