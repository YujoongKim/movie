package com.techelevator.imdb_movies.controller;

import com.techelevator.imdb_movies.dao.MovieDao;
import com.techelevator.imdb_movies.exception.MovieAlreadyExistsException;
import com.techelevator.imdb_movies.model.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin
public class MovieController{

    private MovieDao movieDao;

    public MovieController(MovieDao movieDao){
        this.movieDao = movieDao;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value= "/favoriteMovie", method = RequestMethod.GET)
    public List<Movie> getAllMovies(){
        return movieDao.getAllMovies();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/favorite-movie/{id}", method = RequestMethod.GET)
    public Movie getMovieById(@PathVariable Long id){
        return movieDao.getMovieById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Movie addMovie(@RequestBody Movie movieToSave)throws MovieAlreadyExistsException{
        Movie movie = movieDao.findMovieByTitleId(movieToSave.getTitleId());
    if(movie==null) {
        return movieDao.addMovie(movieToSave);
    }else{
        throw new MovieAlreadyExistsException();
    }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public boolean updateMovie(@RequestBody Movie movie){
        return movieDao.updateMovie(movie);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean deleteMovie(@PathVariable Long id){
        return movieDao.deleteMovie(id);
    }

}