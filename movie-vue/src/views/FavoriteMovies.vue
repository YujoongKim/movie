<template>
  <div id="main">
    <list-favorite-movies />
  </div>
</template>

<script>
import ListFavoriteMovies from '../components/ListFavoriteMovies.vue';

export default {
  name: "ListFavoriteMovies",
  components: {
    ListFavoriteMovies,
  },
};
</script>

<style>
</style>