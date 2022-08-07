# Movie Application

## Back End

This is an application that performs searshing popular 250 movies information saving favorite movie in the DB. 
It supports the following calls:

## Favorite Movies List (GET): 

Builds an favorite movie list
Sample call: 

```http://localhost:8080/favoriteMovie```


## Add favorite movie into DB (POST): 

Returns the added Movie 
  Sample call: 
  
  ```http://localhost:8080/add```

## Movie in the DB (GET): 

Returns the present value of a single favorite Movie
  
Sample call: 

```http://localhost:8080/favorite-movie/{id}```

    
## Architecture

* Server:
    * SpringBoot (in Java)
    * Maven

* Testing:
    * Unit Tests through JUnit
    * Endpoint Testing through RestAssured

## Front End

This is a VUE application that consumes the movie api 
from "https://imdb-api.com/en/API". It allows the user to see Top 250 movies list and details. Also the app has a favorite function it saves on to personal database and also user can see the list of favorite movies.

* Movie List 
* Movie Details
* Make favorite movies from the list 
* Favorite Movie list 
* Search function by movie name

## Project setup

```
npm install
npm run serve
```
### Customize configuration

See [Configuration Reference](https://cli.vuejs.org/config/).


## Visuals

![screenshot](https://github.com/YujoongKim/readme-files/blob/3d35f47a44b2f933ff0534062d9ab7ed704a9be2/movie-vue.png)

