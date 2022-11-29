package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity("sucess", HttpStatus.CREATED);
    }
    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity("sucess",HttpStatus.CREATED);
    }
    /*@PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie,@RequestParam("director") String director){
        movieService.addMovieDirectorPair(director,movie);
        return new ResponseEntity("sucess",HttpStatus.ACCEPTED);
    }
    @GetMapping("/check")
    public Map<String,String> check(){
        return movieService.check();
    }*/
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
        return new ResponseEntity(movieService.getMovieByName(name),HttpStatus.ACCEPTED);
    }
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){
        return new ResponseEntity(movieService.getDirectorByName(name),HttpStatus.ACCEPTED);
    }
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        return new ResponseEntity(movieService.findAllMovies(),HttpStatus.ACCEPTED);
    }
}
