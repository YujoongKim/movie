package com.techelevator.imdb_movies.dao;

import com.techelevator.imdb_movies.model.Movie;

import java.util.List;

public interface MovieDao {
    Movie addMovie(Movie movie);
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
    boolean updateMovie(Movie movie);
    boolean deleteMovie(Long id);
    Movie findMovieByTitleId(String titleId);

}