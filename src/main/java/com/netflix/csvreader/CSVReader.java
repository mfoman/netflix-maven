package com.netflix.csvreader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Objects;

/**
 * [TODO]
 * - We create a CSVReader
 * - It can work with a specific file
 * - - set separator
 * - - - set nested separator? and return multi-array
 * - Make extendable
 * - Close for currentFile
 * - ReturnValue?
 */
public class CSVReader {
    private char separator;
    private File currentFile;
    private InputStream streamFile = null;

    public CSVReader(InputStream currentFile, char separator) {
        this.streamFile = currentFile;
        this.separator = separator;
    }

    public CSVReader(String inputFilePath, char separator) {
        this.currentFile = new File(inputFilePath);
        this.separator = separator;
    }

    public String[] parseLine(String line, char separator) {
        return line.split(String.valueOf(separator));
    }

    public BufferedReader processInputFile() {
        /*
                    return new BufferedReader(new FileReader(this.currentFile));
        */
        // Support utf8
        return new BufferedReader(new InputStreamReader(Objects.requireNonNull(this.streamFile), StandardCharsets.UTF_8));
    }
}
