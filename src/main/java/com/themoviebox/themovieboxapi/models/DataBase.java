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

        String title = (String) movie.get("title");

        String posterPath = (String) movie.get("poster_path");

        // Double or Long
        double voteAverage;
        if (movie.get("vote_average") instanceof Long) {
            Long test = (Long) movie.get("vote_average");
            voteAverage = test.doubleValue();
        } else {
            voteAverage = (double) movie.get("vote_average");
        }

        String overview = (String) movie.get("overview");

        JSONArray genreIds = (JSONArray) movie.get("genre_ids");

        String releaseDate = (String) movie.get("release_date");

        double popularity = (double) movie.get("popularity");

        return new Movie(id, title, posterPath, voteAverage, overview, genreIds, releaseDate, popularity);

    }

}