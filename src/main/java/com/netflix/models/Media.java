package com.netflix.models;

import java.io.File;

public abstract class Media {
    private String title;
    private String[] genre;
    private Float rating;
    private File imageSrc;
    private File mediaSrc;

    public Media(String title, String[] genres, Float rating, File mediaSrc, File imgSrc) {
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

    public Float getRating() {
        return rating;
    }

    public File getMediaSrc() {
        return mediaSrc;
    }

    public File getImageSrc() {
        return imageSrc;
    }

    public abstract void Play();

    public abstract void Pause();

    public abstract void Stop();

    public abstract void setTime();

}
