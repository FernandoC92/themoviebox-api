package com.themoviebox.themovieboxapi.controllers;
import java.util.ArrayList;
import java.util.List;

import com.themoviebox.themovieboxapi.models.DataQuery;
import com.themoviebox.themovieboxapi.models.Movie;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/discover")
public class DiscoverController {

    @GetMapping
    public List<Movie> getSortBy(@Nullable @RequestParam(name="sort_by") String sortBy, @Nullable @RequestParam(name="with_genre") String withGenre) {

        List<Movie> response = new ArrayList<Movie>();

        DataQuery dataQuery = new DataQuery();

        if (nonNull(sortBy)) {
            if (sortBy.equals("popularity.desc")) {
                response = dataQuery.sortBy(sortBy);
            } else if (sortBy.equals("vote_average.desc")) {
                response = dataQuery.sortBy(sortBy);
            }
        } else if (withGenre != null) {
            response = dataQuery.sortBy(withGenre);
        }

        return response;

    }

    private boolean nonNull(String sortBy) {
        boolean isNull;
        if (sortBy != null) {
            isNull = true;
        } else {
            isNull = false; 
        }
        return isNull;
    }
    
}