package com.netflix.csvreader;

import com.netflix.App;
import com.netflix.models.Season;
import com.netflix.models.Series;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SeriesReader extends CSVReader {
    private List<Series> series;

    public SeriesReader(InputStream currentFile) {
        super(currentFile);
        this.series = new ArrayList<>();
    }

    public List<Series> getAllSeries() throws NoImageException {
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

            String title = fields[0].trim();
            String[] dates = fields[1].trim().split("-");
            Date startDate = new Date(Integer.valueOf(dates[0]));

            Date endDate = null;
            if (2 <= dates.length) {
                endDate = new Date(Integer.valueOf(dates[1]));
            }

            String[] genres = this.parseLine(fields[2].trim(), ',');
            String[] genresTrimmmed = Arrays.stream(genres).map(String::trim).toArray(String[]::new);

            Float rating = Float.valueOf(fields[3].trim().replace(',', '.'));

            String[] seasonEpisodes = fields[4].trim().split(",");

            File mediaSrc = new File("./assets/media");

            InputStream imgSrc = App.class.getResourceAsStream("assets/imgs/series/" + title + ".jpg");
            if (imgSrc == null) throw new NoImageException("Can't find corresponding image in resources.");

            Series series = new Series(title, genresTrimmmed, rating, mediaSrc, imgSrc, startDate, endDate);

            for(String se : seasonEpisodes){
                Integer seasonNumber = Integer.valueOf(se.split("-")[0].trim());
                Integer episodesCount = Integer.valueOf(se.split("-")[1].trim());
                Season season = new Season(seasonNumber, episodesCount);
                series.addSeason(season);
            }

            this.series.add(series);
        }

        return this.series;
    }
}
