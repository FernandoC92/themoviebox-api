package com.themoviebox.themovieboxapi.controllers;
import java.util.ArrayList;
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
    public List<Movie> getMostPopular(@RequestParam(name="sort_by") String sort_by) {

        List<Movie> response = new ArrayList<Movie>();
        List<Movie> result = new ArrayList<Movie>();
        DataBase dataBase = new DataBase();
        response = dataBase.generateListMovies();

        System.out.println("sort_by: " + sort_by);

        response.forEach(obj ->{
            
        });


        return response;

    }

}