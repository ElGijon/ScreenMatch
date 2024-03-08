package com.gijon.screenmatch.main;

import com.gijon.screenmatch.calculator.TimeCalculator;
import com.gijon.screenmatch.calculator.RecommendationFilter;
import com.gijon.screenmatch.models.Episode;
import com.gijon.screenmatch.models.Movie;
import com.gijon.screenmatch.models.Series;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie myMovie = new Movie("The Godfather", 1970);
        myMovie.setTimeInMinutes(180);
        System.out.println("Movie Length: " + myMovie.getTimeInMinutes());

        myMovie.showCredits();
        myMovie.rate(8);
        myMovie.rate(5);
        myMovie.rate(10);
        System.out.println("Total de avaliações: " + myMovie.getTotalRates());
        System.out.println(myMovie.getAverage());
        //myMovie.somaDasAvaliacoes = 10;
        //myMovie.totalDeAvaliacoes = 1;
        //System.out.println(myMovie.pegaMedia());

        Series lost = new Series("Lost", 2000);
        lost.showCredits();
        lost.setSeason(10);
        lost.setEpisodesPerSeason(10);
        lost.setMinutesPerEpisode(50);
        System.out.println("Duração para maratonar Lost: " + lost.getTimeInMinutes());

        Movie outroFilme = new Movie("Avatar", 2023);
        outroFilme.setTimeInMinutes(200);

        TimeCalculator calculadora = new TimeCalculator();
        calculadora.inclui(myMovie);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTotalTime());

        RecommendationFilter filtro = new RecommendationFilter();
        filtro.filter(myMovie);

        Episode episode = new Episode();
        episode.setNumber(1);
        episode.setSeries(lost);
        episode.setTotalViews(300);
        filtro.filter(episode);

        var filmeDoPaulo = new Movie("Dogville", 2003);
        filmeDoPaulo.setTimeInMinutes(200);
        filmeDoPaulo.rate(10);

        ArrayList<Movie> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoPaulo);
        listaDeFilmes.add(myMovie);
        listaDeFilmes.add(outroFilme);
        System.out.println("Tamanho da lista " + listaDeFilmes.size());
        System.out.println("Primeiro filme " + listaDeFilmes.get(0).getName());
        System.out.println(listaDeFilmes);
        System.out.println("toString do filme " + listaDeFilmes.get(0).toString());


    }
}