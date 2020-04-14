package com.themoviebox.themovieboxapi.models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataBase {
    
    @SuppressWarnings("unchecked")
    public List<Movie> generateListMovies() {

        List<Movie> movies = new ArrayList<Movie>();

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("movies.json")) {

            Object obj = jsonParser.parse(reader);
            JSONArray movieList = (JSONArray) obj;
            System.out.println(movieList);

            movieList.forEach(movie -> movies.add(parseMovieObject((JSONObject) movie)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return movies;

    }

    private Movie parseMovieObject(JSONObject movie) {

        long id = (long) movie.get("id");
        System.out.println(id);

        String title = (String) movie.get("title");
        System.out.println(title);

        String posterPath = (String) movie.get("poster_path");
        System.out.println(posterPath);

        double voteAverage = (double) movie.get("vote_average");
        System.out.println(voteAverage);

        String overview = (String) movie.get("overview");
        System.out.println(overview);

        long genreIds = (long) movie.get("genre_ids");
        System.out.println(genreIds);

        String releaseDate = (String) movie.get("release_date");
        System.out.println(releaseDate);

        double popularity = (double) movie.get("popularity");
        System.out.println(popularity);

        return new Movie(id, title, posterPath, voteAverage, overview, genreIds, releaseDate, popularity);

    }

}