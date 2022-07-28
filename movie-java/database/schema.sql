BEGIN TRANSACTION;
DROP TABLE IF EXISTS movie;
CREATE TABLE movie(
                      id serial NOT NULL,
                      title_id VARCHAR(10) NOT NULL,
                      title VARCHAR(100),
                      year VARCHAR(4),
                      image VARCHAR(200),
                      genres VARCHAR (200),
                      starlist VARCHAR (200),
                      CONSTRAINT PK_id PRIMARY KEY (id)
);

INSERT INTO movie (title_id, title, year, image, genres, starlist) VALUES ('tt0411008', 'Lost', '2004', 'https://imdb-api.com/images/original/MV5BNzhlY2E5NDUtYjJjYy00ODg3LWFkZWQtYTVmMzU4ZWZmOWJkXkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_Ratio0.6751_AL_.jpg', 'Adventure, Drama, Fantasy', 'Jorge Garcia, Josh Holloway, Yunjin Kim');
INSERT INTO movie (title_id, title, year, image, genres, starlist) VALUES ('tt0111161', 'The Shawshank Redemption', '1994', 'https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,3,128,176_AL_.jpg', 'Drama', 'Tim Robbins, Morgan Freeman, Bob Gunton');
COMMIT;