package com.netflix.models;

import java.util.*;

public class Series {
    private String title;
    private Date start;
    private Date end;
    private List<Season> seasons;

    public String getTitle() {
        return title;
    }

    public Series(String title, Date start, Date end) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.seasons = new ArrayList<>();
    }

    public void addSeason(Season season) {
        this.seasons.add(season);
    }
}
