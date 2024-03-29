package com.netflix.csvreader;

import com.netflix.App;
import com.netflix.models.Movie;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MovieReader extends CSVReader {
    private List<Movie> movies;

    public MovieReader(InputStream inputFilePath) {
        super(inputFilePath);
        this.movies = new ArrayList<>();
    }

    public List<Movie> getAllMovies() throws NoImageException {
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
            String[] genresTrimmmed = Arrays.stream(genres).map(String::trim).toArray(String[]::new);

            String title = fields[0].trim();
            Date date = new Date(Integer.valueOf(fields[1].trim()));
            Float rating = Float.valueOf(fields[3].trim().replace(',', '.'));

            File mediaSrc = new File("./assets/media");

            InputStream imgSrc = App.class.getResourceAsStream("assets/imgs/movies/" + title + ".jpg");
            if (imgSrc == null) throw new NoImageException("Can't find corresponding image in resources.");

            this.movies.add(new Movie(title, date, genresTrimmmed, rating, mediaSrc, imgSrc));
        }

        return this.movies;
    }
}
