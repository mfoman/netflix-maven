package com.netflix.models;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

public class Episode extends Media {

    public Episode(String title, Date release, String[] genres, File mediaSrc, InputStream imgSrc) {
        super(title, genres, (float) 0.0, new File("./assets/series-imgs/"), imgSrc);
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
