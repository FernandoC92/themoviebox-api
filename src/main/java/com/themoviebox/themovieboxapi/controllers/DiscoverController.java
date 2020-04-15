package com.themoviebox.themovieboxapi.controllers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.themoviebox.themovieboxapi.models.DataBase;
import com.themoviebox.themovieboxapi.models.Movie;

import org.json.simple.JSONArray;
import static java.util.Objects.nonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discover")
public class DiscoverController {
    // /discover/movie?sort_by=popularity.desc
    // /discover/movie?with_genres=28

    @GetMapping
    public List<Movie> getSortBy(@Nullable @RequestParam(name="sort_by") String sortBy, @Nullable @RequestParam(name="with_genre") Long withGenre) {

        List<Movie> response = new ArrayList<Movie>();
      
        DataBase dataBase = new DataBase();
        response = dataBase.generateListMovies();

        System.out.println("sort_by: " + sortBy);

        if (nonNull(sortBy)) {
            if (sortBy.equals("popularity.desc")) {
                System.out.println("popularity.desc");
                Collections.sort(response, new SortByPopularity());
            } else if (sortBy.equals("vote_average")) {
                System.out.println("vote_average");
                Collections.sort(response, new SortByVoteAverage());
            }
        } else if (withGenre != null) {
            response = response.stream().filter(m ->m.getGenreIds().contains(withGenre)).collect(Collectors.toList());
        }

        return response;

    }

    private boolean nonNull(String sortBy) {
        return false;
    }

}

class SortByPopularity implements Comparator<Movie> {
    
    public int compare(Movie a, Movie b) {
        return Double.compare(b.getPopularity(), a.getPopularity());
    }

}

class SortByVoteAverage implements Comparator<Movie> {

    public int compare(Movie a, Movie b) {
        return Double.compare(b.getVoteAverage(), a.getVoteAverage());
    }

}