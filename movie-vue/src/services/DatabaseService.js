import axios from 'axios';
// import { get } from 'core-js/core/dict';

const http = axios.create({
    baseURL: "http://localhost:8080/movies"
} );

export default {

    saveMovie(movie) {
        return http.post("/add", movie);
        
    },

    getAllFavoriteMovies(){
        return http.get("/favoriteMovie");
    },

    getFavoriteMovieDetail(id) {
        return http.get(`/favorite-movie/${id}`);
    },

    deleteFavoriteMovie(id) {
        return http.get(`/delete/${id}`)
    }



}