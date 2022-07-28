package com.techelevator.imdb_movies.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT, reason = "Movie already exists in favorites.")
public class MovieAlreadyExistsException extends RuntimeException{

}
