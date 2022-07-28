<template>
  <div id="main">
    <h1>Movie Detail</h1>
    <button @click="saveMovie">Add to Favorites</button>
    <div id="content">
      <img :src="movie.image" alt="" />
      <div class="detail">
        <h2>Name: {{ movie.title }}</h2>
        <h3>Year: {{ movie.year }}</h3>
        <h4>Genres: {{movie.genres}}</h4>
        <p>{{ movie.plot }}</p>
        <h4>Stars:</h4>
        <!-- <p>Character: Actor:</p> -->
        <div id="stars" v-for="star in movie.actorList" :key="star.id">
          <p>{{ star.asCharacter }}</p>
          <p>{{ star.name }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import MovieService from "../services/MovieService";
import DatabaseService from "../services/DatabaseService";

export default {
  name: "movie-detail",
  data() {
    return {
      movie: Object,
    };
  },
  created() {
    MovieService.getDetail(this.$route.params.movieId).then((response) => {
      // console.log(response.data);
      this.movie = response.data;
    });
  },
  methods: {
    saveMovie() {
      const movieToSave = {

        titleId : this.movie.id,
        title : this.movie.title,
        year : this.movie.year,
        image : this.movie.image, 
        genres : this.movie.genres,
        starlist : this.movie.stars

      }
      DatabaseService.saveMovie(movieToSave)
      .then((response) => {
       if(response.status === 201 || response.status === 200) {
        alert (this.movie.title + " has been added to your favorites!");
        this.$router.push("/movies")
       }
      })
      .catch((error) => {
        if (error.response.status === 418){
          alert(error.response.data.message);
        } else {
          alert("ERROR! " + error.response.status);
        }
        this.$router.push("/movies")
      });
    }
  }
};
</script>

<style scoped>
#content {
  display: flex;
}
.detail {
  text-align: left;
  margin: 5em 30em 10em 5em;
}
img {
  height: 400px;
  width: auto;
  margin: 5em;
}
#stars {
  display: flex;
  justify-content: space-around;
  align-items: flex-start;
}
</style>