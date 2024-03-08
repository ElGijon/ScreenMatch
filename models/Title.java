package com.gijon.screenmatch.models;

import com.gijon.screenmatch.exceptions.InvalidYearException;
import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title> {
    private String name;
    private int releaseYear;
    private boolean isItIncludedInPlan;
    private double ratingsSum;
    private int totalRates;
    private int timeInMinutes;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public Title(OMDBTitle myOMDBTitle) {
        this.name = myOMDBTitle.title();

        if (myOMDBTitle.year().length() > 4){
            throw new InvalidYearException("The year format is wrong! There is more than 4 characters in 'Year'");
        }
        this.releaseYear = Integer.valueOf(myOMDBTitle.year());
        this.timeInMinutes = Integer.valueOf(myOMDBTitle.runtime().substring(0,2));
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isItIncludedInPlan() {
        return isItIncludedInPlan;
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    public int getTotalRates() {
        return totalRates;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setItIncludedInPlan(boolean itIncludedInPlan) {
        this.isItIncludedInPlan = itIncludedInPlan;
    }

    public void setTimeInMinutes(int timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

    public void showCredits(){
        System.out.println("Movie Name: " + name);
        System.out.println("Release Year: " + releaseYear);
    }

    public void rate (double rating){
        ratingsSum += rating;
        totalRates++;
    }

    public double getAverage(){
        return ratingsSum / totalRates;
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }

    @Override
    public String toString() {
        return "(Title: " + name + '\'' +
                " Year: " + releaseYear +
//                " Rating: " + ratingsSum +
//                " Votes: " + totalRates +
                " Total Time (minutes): " + timeInMinutes + ")";
    }
}
