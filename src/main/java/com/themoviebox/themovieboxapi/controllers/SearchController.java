package com.themoviebox.themovieboxapi.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.themoviebox.themovieboxapi.models.DataBase;
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

        List<Movie> queryList = new ArrayList<Movie>();

        DataBase dataBase = new DataBase();

        queryList = dataBase.generateListMovies();

        queryList = queryList.stream().filter(movie -> movie.getTitle().toUpperCase().contains(query.toUpperCase()))
        .collect(Collectors.toList());

        return queryList;

    }

}