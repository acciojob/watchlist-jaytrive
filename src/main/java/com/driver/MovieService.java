package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Component
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
     public void addMovie(Movie movie){
         movieRepository.addMovie(movie);
     }
     public void addDirector(Director director){
         movieRepository.addDirector(director);
     }
    /*public void addMovieDirectorPair(String movie, String director){
         movieRepository.addMovieDirectorPair(director,movie);
    }
    public Map<String,String> check(){
        return movieRepository.check();
    }*/
    public Movie getMovieByName(String movie){
        return movieRepository.getMovieByName(movie);
    }
    public Director getDirectorByName(String director){
        return movieRepository.getDirectorByName(director);
    }
    public List<Movie> findAllMovies(){
         return movieRepository.findAllMovies();
    }
}
