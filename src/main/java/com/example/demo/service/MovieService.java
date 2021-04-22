package com.example.demo.service;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;

    public List<Movie> GET_Movies(){
        return repository.findAll();
    }

    public Movie GET_Movie(Long id){
        return repository.findById(id).orElse(null);
    }

    public Movie GET_MovieByName(String name){
        return repository.findByName(name);
    }

    public Movie POST_Movie(Movie movie){
        return repository.save(movie);
    }

    public String DELETE_Movie(long id){
        repository.deleteById(id);
        return "Movie deleted with id: "+id;
    }

    public Movie PUT_Movie(Movie movie){
        Movie existingMovie = repository.findById(movie.getId()).orElse(null);
        existingMovie.setName(movie.getName());
        existingMovie.setRating(movie.getRating());
        return repository.save(existingMovie);
    }
}
