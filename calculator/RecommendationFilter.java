package com.gijon.screenmatch.calculator;

public class RecommendationFilter {
    private String recommendation;

    public void filter(Rateable rateable) {
        if (rateable.getRating() >= 4) {
            System.out.println("It is one of the crowd's favourites!");
        } else if (rateable.getRating() >= 3) {
            System.out.println("Very highly rated!");
        } else {
            System.out.println("Definitely a good choice!");
        }
    }
}
