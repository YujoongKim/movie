import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Movies from '../views/Movies.vue'
import Detail from '../views/Detail.vue'
import ListFavoriteMovies from '../components/ListFavoriteMovies.vue'
import FavoriteMovieDetail from '../components/FavoriteMovieDetail.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/movies',
    name: 'Movies',
    component: Movies
  },
  {
    path: '/favorite-movies',
    name: 'ListFavoriteMovies',
    component: ListFavoriteMovies
  },

  {
    path: '/favorite-movie/:movieId',
    name: 'FavoriteMovieDetail',
    component: FavoriteMovieDetail
  },

  {
    path: '/movie/:movieId',
    name: 'Detail',
    component: Detail
  },

]

const router = new VueRouter({
  routes
})

export default router
