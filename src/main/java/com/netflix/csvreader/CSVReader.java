package com.netflix.csvreader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class CSVReader {
    private InputStream streamFile = null;

    public CSVReader(InputStream inputStream) {
        this.streamFile = inputStream;
    }

    public String[] parseLine(String line, char separator) {
        if (line.equals("")) throw new CantParseException("Line is empty");
        return line.split(String.valueOf(separator));
    }

    public BufferedReader processInputFile() {
        // This line reads a file into a buffer with utf-8 unicode encoding
        return new BufferedReader(new InputStreamReader(Objects.requireNonNull(this.streamFile), StandardCharsets.UTF_8));
    }
}
