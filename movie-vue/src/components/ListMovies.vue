<template>
  <div id="main">
    <h1>List of Movies</h1>
    <div id = "container">
      Search with Movie Name: 
      <input type = "text" id="SearchBar" v-model="filter"/>
      </div>
    
    <br>
    <button id="last" :disabled="starting === 0" @click="lastTwenty">
      Back
    </button>
    <button id="next" :disabled="ending > 240" @click="nextTwenty">Next</button>
    <div class="movie-container">
      <movie-card
        v-for="movie in filteredList"
        :movie="movie"
        :key="movie.id"
      ></movie-card>
    </div>

  </div>
</template>

<script>

import MovieCard from "@/components/MovieCard.vue";

export default {
  name: "list-movies",
  components: {
    MovieCard,
},
  computed: {
    filteredList() {  
      
        let allTheMovies = this.allTheMovies;
        let filteredMovies = [];

      if(this.filter == "") {
        return allTheMovies; 
      }
      
      else if(this.filter != "") {
        filteredMovies = allTheMovies.filter((movie) =>
        movie.title.toLowerCase()
        .includes(this.filter.toLowerCase())
    )}
    return filteredMovies;
      }
  },



  data() {
    return {
      movie:Object,
      starting: 0,
      ending: 20,
      // slicedMovies: this.$store.state.movies.slice(0, 20), //cut the results only 20
      allTheMovies: this.$store.state.movies,
      filter: ""
    };
  },



  methods: {
    
    nextTwenty() {
      this.starting += 20;
      this.ending += 20;
      this.allTheMovies = this.$store.state.movies.slice(
        this.starting,
        this.ending
      );
    },

    lastTwenty() {
      this.starting -= 20;
      this.ending -= 20;
      this.allTheMovies = this.$store.state.movies.slice(
        this.starting,
        this.ending
      );
    },
  },
};
</script>

<style>
.movie-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
.container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>