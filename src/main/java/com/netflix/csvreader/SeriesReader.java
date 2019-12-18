package com.netflix.csvreader;

import com.netflix.models.Season;
import com.netflix.models.Series;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeriesReader extends CSVReader {
    private List<Series> series;

    public SeriesReader(String inputFilePath, char separator) {
        super(inputFilePath, separator);
        this.series = new ArrayList<>();
    }

    public List<Series> getAllSeries() {
        // Load each episode
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
            Float rating = Float.valueOf(fields[3].trim().replace(',', '.'));

            String[] seasonEpisodes = fields[4].trim().split(",");

            File mediaSrc = new File("./assets/media");

            File imgSrc = new File("./assets/series-imgs/" + title + ".jpg");
            if (!imgSrc.exists()) {
                System.out.println("File not found - image" + title);
            }

            /**
             * [TODO] Make a season class for each season.
             * Make episode class for each episode in that season.
             * Put respective episode class in each season class.
             * Put all season class in series class.
             * Add series class to this.series.
             *
             * Maybe need a addEpisode method in season class
             * And a addSeason in series class to make it work.
             */

            Series series = new Series(title, startDate, endDate);

            //public Series(HashMap<String, Date> duration, Date start, Date end, HashMap<Integer, Season> seasons, HashMap<Integer, Episode> episodes) {

            // ["1-13", "2-13", "3-13"]
            for(String se : seasonEpisodes){
                // se = "1-13".split(-)
                // String[] array = [" 1", " 13"]
                // array[1]
                // Integer.valueof(array[1])
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
