<template>
  <div class="card" @click="viewFavoriteMovieDetail(movie.id)">
    <h2>{{ movie.title }}</h2>
    <img :src="movie.image" alt="image" />
    <h4>{{ movie.starlist }}</h4>
    <button>Remove from favorite</button>
  </div>
</template>

<script>

export default {
  name: "favorite-movie-card",
  props: {
    movie: Object,
  },
  
  methods: {
    viewFavoriteMovieDetail(movieId) {
      this.$router.push(`/favorite-movie/${movieId}`);
    },
  },
};
</script>

<style>
.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
}
.card > img {
  height: 200px;
  width: auto;
}
</style>