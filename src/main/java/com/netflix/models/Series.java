package com.netflix.models;

import java.io.File;
import java.io.InputStream;
import java.util.*;

public class Series extends Media {
    private Date start;
    private Date end;
    private List<Season> seasons;

    public Series(String title, String[] genres, Float rating, File mediaSrc, InputStream imgSrc, Date start, Date end) {
        super(title, genres, rating, mediaSrc, imgSrc);
        this.start = start;
        this.end = end;
        this.seasons = new ArrayList<>();
    }

    public void addSeason(Season season) {
        this.seasons.add(season);
    }

    @Override
    public void Play() {

    }

    @Override
    public void Pause() {

    }

    @Override
    public void Stop() {

    }

    @Override
    public void setTime() {

    }
}
