package com.netflix.csvreader;

import com.netflix.models.Movie;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieReader extends CSVReader {
    private List<Movie> movies;

    public MovieReader(String inputFilePath, char separator) {
        super(inputFilePath, separator);
        this.movies = new ArrayList<>();
    }

    public List<Movie> getAllMovies() {
        BufferedReader br = this.processInputFile();

        String line = null;
        while (true) {
            try {
                line = br.readLine();
                if (line == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] fields = this.parseLine(line, ';');
            String[] genres = this.parseLine(fields[2].trim(), ',');

            String title = fields[0].trim();
            Date date = new Date(Integer.valueOf(fields[1].trim()));
            Float rating = Float.valueOf(fields[3].trim().replace(',', '.'));

            File mediaSrc = new File("./assets/media");

            File imgSrc = new File("./assets/films-imgs/" + title + ".jpg");
            if (!imgSrc.exists()) {
                System.out.println("File not found - image" + title);
            }

            this.movies.add(new Movie(title, date, genres, rating, mediaSrc, imgSrc));
        }

        return this.movies;
    }
}
