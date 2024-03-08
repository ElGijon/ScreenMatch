package com.gijon.screenmatch.models;

public class Series extends Title {
    private int season;
    private boolean isActive;
    private int episodesPerSeason;
    private int minutesPerEpisode;

    public Series(String name, int releaseYear) {
        super(name, releaseYear);
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public int getMinutesPerEpisode() {
        return minutesPerEpisode;
    }

    public void setMinutesPerEpisode(int minutesPerEpisode) {
        this.minutesPerEpisode = minutesPerEpisode;
    }

    @Override
    public int getTimeInMinutes() {
        return season * episodesPerSeason * minutesPerEpisode;
    }

    @Override
    public String toString() {
        return "Series: " + this.getName() + "(" + this.getReleaseYear() + ")";
    }
}
