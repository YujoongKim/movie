# Movie 

## Introduction
This is an API microservice that performs saving favorite movie in the DB. It supports 
the following calls:

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
