<template>
  <div id="main">
    <list-movies />
  </div>
</template>

<script>
import ListMovies from "../components/ListMovies.vue";
export default {
  name: "Movies",
  components: {
    ListMovies,
  },
};
</script>

<style>
</style>