import axios from 'axios';

const http = axios.create({
    baseURL: "https://imdb-api.com/en/API"
});
const API_KEY = "k_6npkia6u";

export default {
    list() {
        return http.get('/Top250Movies/' + API_KEY);
    },
    getDetail(id) {
        return http.get(`/title/${API_KEY}/${id}`);
    },

    searchMovie(expression) {
        return http.get(`/SearchMovie/${API_KEY}/${expression}`)
    }

}