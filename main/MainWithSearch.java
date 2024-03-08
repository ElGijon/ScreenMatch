package com.gijon.screenmatch.main;

import com.gijon.screenmatch.exceptions.InvalidYearException;
import com.gijon.screenmatch.models.OMDBTitle;
import com.gijon.screenmatch.models.Title;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner reading = new Scanner(System.in);
        String search = "";
        List<Title> titles = new ArrayList<>();

        Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

        while (!search.equalsIgnoreCase("exit")) {
            System.out.println("Search for a movie: ");
            search = reading.nextLine();

            if (search.equalsIgnoreCase("exit")){
                break;
            }

            String address = "https://www.omdbapi.com/?t=" + search.replace(" ","+") + "&apikey=7f3bc465";

            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();
                HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);

                OMDBTitle myOMDBTitle = gson.fromJson(json, OMDBTitle.class);
                System.out.println(myOMDBTitle);

                Title myTitle = new Title(myOMDBTitle);
                System.out.println("Title :");
                System.out.println(myTitle);

                titles.add(myTitle);

            } catch (NumberFormatException e){
                System.out.println("Error!");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e){
                System.out.println("Invalid Argument!");
            } catch (InvalidYearException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titles);

        FileWriter writing = new FileWriter("movies.json");
        writing.write(gson.toJson(titles));
        writing.close();
    }
}
