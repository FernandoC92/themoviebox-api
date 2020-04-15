package com.themoviebox.themovieboxapi.controllers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.themoviebox.themovieboxapi.models.DataBase;
import com.themoviebox.themovieboxapi.models.Movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discover")
public class DiscoverController {
    // /discover/movie?sort_by=popularity.desc

    @GetMapping
    public List<Movie> getSortBy(@RequestParam(name="sort_by") String sortBy) {

        List<Movie> response = new ArrayList<Movie>();
      
        DataBase dataBase = new DataBase();
        response = dataBase.generateListMovies();

        System.out.println("sort_by: " + sortBy);

        if (sortBy.equals("popularity.desc")) {
            System.out.println("popularity.desc");
            Collections.sort(response, new SortByPopularity());
        } else {
            System.out.println("vote_average");
            Collections.sort(response, new SortByVoteAverage());
        } 

        return response;

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