package com.netflix.models;

import java.util.HashMap;

public class Season {
    private HashMap<Integer,Episode> episodes;
    private Integer episodesCount;
    private Integer seasonNumber;

    public Season(Integer seasonNumber, Integer episodesCount) {
        this.seasonNumber = seasonNumber;
        this.episodesCount = episodesCount;
    }
    public Season(HashMap<Integer, Episode> episodes) {
         this.episodes = new HashMap<>();
    }

}
