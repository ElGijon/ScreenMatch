package com.gijon.screenmatch.main;

import com.gijon.screenmatch.models.Movie;
import com.gijon.screenmatch.models.Series;
import com.gijon.screenmatch.models.Title;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MainWithLists {
    public static void main(String[] args) {
        Movie movie1 = new Movie("The Godfather", 1970);
        movie1.rate(8);
        Movie movie2 = new Movie("Avatar", 2023);
        movie2.rate(5);
        var movie3 = new Movie("Dogville", 2003);
        movie3.rate(10);
        Series series1 = new Series("Lost", 2000);

        Movie m1 = movie3;

        ArrayList<Title> list = new ArrayList<>();
        list.add(movie3);
        list.add(movie1);
        list.add(movie2);
        list.add(series1);
        for (Title item: list) {
            System.out.println(item.getName());
            if (item instanceof  Movie filme && filme.getRating() > 2) {
                System.out.println("Rating: " + filme.getRating());
            }
        }

        List<String> searchByArtist = new LinkedList<>();
        searchByArtist.add("Adam Sandler");
        searchByArtist.add("Robert deNiro");
        searchByArtist.add("Daniel Day-Lewis");
        System.out.println(searchByArtist);

        Collections.sort(searchByArtist);
        System.out.println(searchByArtist);
        System.out.println("Lists of titles ordered: ");
        Collections.sort(list);
        System.out.println(list);
        list.sort(Comparator.comparing(Title::getReleaseYear));
        System.out.println("Ordered by year: ");
        System.out.println(list);
    }
}
