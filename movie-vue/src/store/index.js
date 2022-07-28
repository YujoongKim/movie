import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    movies: [],
    favoriteMovies:[],
  },
  mutations: {
    SET_MOVIES(state, data) {
      state.movies = data;
    },
    SET_FAVORITE_MOVIES(state, data) {
      state.favoriteMovies = data;
    }
  },
  actions: {},
  modules: {},
});
