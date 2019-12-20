package com.netflix.csvreader;

import com.netflix.App;
import com.netflix.models.Series;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeriesReaderTest {

    @Test
    void getAllSeries() {
        List<Series> s = null;
        
        try {
            s = new SeriesReader(App.class.getResourceAsStream("assets/serier.txt")).getAllSeries();
        } catch (NoImageException e) {
            e.printStackTrace();
        }
        
        assertEquals(100, s.size());
    }
}