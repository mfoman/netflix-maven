package com.netflix.csvreader;

import java.io.*;
import java.util.HashMap;

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
    private HashMap<String, HashMap> results;

    public CSVReader(String inputFilePath, char separator) {
        this.currentFile = new File(inputFilePath);
        this.separator = separator;
    }

    public String[] parseLine(String line, char separator) {
        return line.split(String.valueOf(separator));
    }

    public BufferedReader processInputFile() {
        try {
/*
            return new BufferedReader(new FileReader(this.currentFile));
*/

            // Support utf8
            return new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(this.currentFile),
                            "UTF8"
                    )
            );
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
