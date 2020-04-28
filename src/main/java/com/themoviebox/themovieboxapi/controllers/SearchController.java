package com.themoviebox.themovieboxapi.controllers;

import java.util.List;

import com.themoviebox.themovieboxapi.models.DataQuery;
import com.themoviebox.themovieboxapi.models.Movie;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/search")
public class SearchController {

    @GetMapping
    public List<Movie> queryName(@Nullable @RequestParam(name = "query") String query) {

        DataQuery dataQuery = new DataQuery();

        return dataQuery.GetByName(query);

    }

}