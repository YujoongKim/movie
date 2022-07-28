package com.techelevator.imdb_movies.dao;

import com.techelevator.imdb_movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieDaoJdbc implements MovieDao{

    private JdbcTemplate jdbcTemplate;

    public MovieDaoJdbc(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Override
    public Movie addMovie(Movie movie) {
        String sql  = "INSERT INTO movie (title_id, title, year, image, genres, starlist) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING id;";
        Long movieId = jdbcTemplate.queryForObject(sql, Long.class, movie.getTitleId(), movie.getTitle(), movie.getYear(), movie.getImage(), movie.getGenres(), movie.getStarlist());

        movie.setId(movieId);
        return movie;
    }

    @Override
    public List<Movie> getAllMovies(){
        List<Movie> movies = new ArrayList<Movie>();
        String sql = "SELECT * FROM movie";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            movies.add(mapRowToMovie(results));
        }
        return movies;
    }

    @Override
    public Movie getMovieById(Long id){
        Movie movie = null;
        String sql = "SELECT * FROM movie WHERE id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        while(result.next()){
            movie = mapRowToMovie(result);
        }

        return movie;
    }

    @Override
    public Movie findMovieByTitleId(String titleId) {

        String sql = "SELECT * FROM movie WHERE title_id =?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, titleId);
        while(results.next()) {

            return mapRowToMovie(results);
        }
        return null;
    }

    @Override
    public boolean updateMovie(Movie movie) {
        String sql = "UPDATE movie SET title_id = ?, title = ?, year = ?, " +
        "image = ?, genres = ?, starlist  = ? WHERE id = ?;";

        int rowUpdated = jdbcTemplate.update(sql, movie.getTitleId(), movie.getTitle(), movie.getYear(),
                movie.getImage(), movie.getGenres(), movie.getStarlist(), movie.getId());

        return rowUpdated == 1;
    }

    @Override
    public boolean deleteMovie(Long id) {
        String sql = "DELETE FROM movie WHERE id = ?;";
        int rowDeleted = jdbcTemplate.update(sql, id);
        return rowDeleted == 1;
    }

    private Movie mapRowToMovie(SqlRowSet rs){
        return new Movie(rs.getLong("id"), rs.getString("title_id"), rs.getString("title"), rs.getString("year"), rs.getString("image"), rs.getString("genres"), rs.getString("starlist"));
    }

}