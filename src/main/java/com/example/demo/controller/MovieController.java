package com.example.demo.controller;

import com.example.demo.entity.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService service;

    @GetMapping("/movies")
    public List<Movie> GET_Movies(){
        return service.GET_Movies();
    }

    @GetMapping("/movie/id/{id}")
    public Movie GET_Movie(@PathVariable long id){
        return service.GET_Movie(id);
    }

    @GetMapping("/movie/name/{name}")
    public Movie GET_MovieByName(@PathVariable String name){
        return service.GET_MovieByName(name);
    }

    @PostMapping("/movie")
    public Movie POST_Movie(@RequestBody Movie movie){
        return service.POST_Movie(movie);
    }

    @PutMapping("/movie")
    public Movie PUT_Movie(@RequestBody Movie movie){
        return service.PUT_Movie(movie);
    }

    @DeleteMapping("/movie/id/{id}")
    public String DELETE_Movie(@PathVariable long id){
        return service.DELETE_Movie(id);
    }
}
