<template>
  <div id="main">
    <h1>List of Your Favorite Movies</h1>
    <div id = "container">
      Search with Movie Name: 
      <input type = "text" id="SearchBar" v-model="filter" />
      </div>
   
    <br>
    <button id="last" :disabled="starting === 0" @click="lastTwenty">
      Back
    </button>
    <button id="next" :disabled="ending > 240" @click="nextTwenty">Next</button>
    <div class="movie-container">
      <favorite-movie-card
        v-for="movie in filteredList"
        :movie="movie"
        :key="movie.id"
      ></favorite-movie-card>
    </div>
  </div>
</template>

<script>
import FavoriteMovieCard from '../components/FavoriteMovieCard.vue';
import DatabaseService from "../services/DatabaseService.js";

export default {
    name: "favorite-movies",
    components : {
        FavoriteMovieCard,
    },

    computed: {
    filteredList() {
      let filteredMovie = [];
      let allTheMovies = this.favoriteMovieList;
      if(this.filter == "") {
        return allTheMovies;
      }

      else if(this.filter != ""){
      
        filteredMovie = allTheMovies.filter((movie) =>
        movie.title.toLowerCase()
        .includes(this.filter.toLowerCase())
    )}
    return filteredMovie;
    }
  },

    data() {
        return {
            movie:Object,
            filter:"",
            favoriteMovieList : [],
            starting: 0,
            ending: 20,
            // allTheMovies: this.favoriteMovieList.slice(0, 20), //cut the results only 20
        };
    },

    created() {
        DatabaseService.getAllFavoriteMovies().then((response) => {
            this.favoriteMovieList=response.data
            })
        },

    filter: {
    titleId : "",
    title : "",
    year : "",
    image : "",
    genres: "",
    starlist: ""

  },

    methods: {

    nextTwenty() {
      this.starting += 20;
      this.ending += 20;
      this.allTheMovies = this.$store.state.favoriteMovies.slice(
        this.starting,
        this.ending
      );
    },

    lastTwenty() {
      this.starting -= 20;
      this.ending -= 20;
      this.allTheMovies = this.$store.state.favoriteMovies.slice(
        this.starting,
        this.ending
      );
    },
  },


}

</script>



<style>
.movie-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>