package com.themoviebox.themovieboxapi.controllers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.themoviebox.themovieboxapi.models.DataBase;
import com.themoviebox.themovieboxapi.models.Movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discover")
public class DiscoverController {
    // /discover/movie?sort_by=popularity.desc

    @GetMapping
    public List<Movie> getMostPopular() {

        List<Movie> response = new ArrayList<Movie>();
        // List<Movie> result = new ArrayList<Movie>();
        DataBase dataBase = new DataBase();
        response = dataBase.generateListMovies();

        // System.out.println("sort_by: " + sort_by);
        
        Collections.sort(response, new SortByPopularity());

        response.forEach(obj ->{
            System.out.println(obj);
        });


        return response;

    }

}

class SortByPopularity implements Comparator<Movie> {
    
    public int compare(Movie a, Movie b) {
        return Double.compare(b.getPopularity(), a.getPopularity());
    }

}