package com.netflix.models;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

public class Movie extends Media {
    private Date release;

    public Date getRelease() {
        return release;
    }

    public Movie(String title, Date release, String[] genres, Float rating, File mediaSrc, InputStream imgSrc) {
        super(title, genres, rating, mediaSrc, imgSrc);
        this.release = release;
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
