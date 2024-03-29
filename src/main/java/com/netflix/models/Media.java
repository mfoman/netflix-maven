package com.netflix.models;

import java.io.File;
import java.io.InputStream;
import java.util.Arrays;

public abstract class Media {
    private String title;
    private String[] genre;
    private Float rating;
    private InputStream imageSrc;
    private File mediaSrc;

    public Media(String title, String[] genres, Float rating, File mediaSrc, InputStream imgSrc) {
        this.title = title;
        this.genre = genres;
        this.rating = rating;
        this.imageSrc = imgSrc;
        this.mediaSrc = mediaSrc;
    }

    public String getTitle() {
        return title;
    }

    public String[] getGenre() {
        return genre;
    }

    public Boolean inGenre(String match) {
        if (match.equals("All")) return true; // This makes sure that every genre is included
        return Arrays.asList(this.genre).contains(match.trim());
    }

    public Float getRating() {
        return rating;
    }

    public File getMediaSrc() {
        return mediaSrc;
    }

    public InputStream getImageSrc() {
        return imageSrc;
    }

    public abstract void Play();

    public abstract void Pause();

    public abstract void Stop();

    public abstract void setTime();

}
