package com.netflix.csvreader;

import com.netflix.App;
import com.netflix.models.Movie;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieReaderTest {

    @Test
    void getAllMovies() {
        List<Movie> s = null;

        try {
            s = new MovieReader(App.class.getResourceAsStream("assets/film.txt")).getAllMovies();
        } catch (NoImageException e) {
            e.printStackTrace();
        }

        assertEquals(100, s.size());
    }
}