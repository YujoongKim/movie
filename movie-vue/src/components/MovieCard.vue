<template>
  <div class="card" @click="viewMovieDetail(movie.id)">
    <h2>{{ movie.title }}</h2>
    <img :src="movie.image" alt="image" />
    <h4>{{ movie.crew }}</h4>
  </div>
</template>

<script>
export default {
  name: "movie-card",
  props: {
    movie: Object,
  },
  methods: {
    viewMovieDetail(movieId) {
      this.$router.push(`/movie/${movieId}`);
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