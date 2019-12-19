package com.netflix.csvreader;

import com.netflix.App;
import com.netflix.models.Movie;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieReaderTest {

    @Test
    void getAllMovies() {
        MovieReader mv = new MovieReader(App.class.getResourceAsStream("assets/film.txt"), ';');

        List<Movie> movies = mv.getAllMovies();

        for (Movie m : movies) {
            System.out.println(m.getTitle());
        }
    }
}