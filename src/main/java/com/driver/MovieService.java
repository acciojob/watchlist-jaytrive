package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
     public void addMovie(Movie movie){
         movieRepository.addMovie(movie);
     }

    public List<Movie> findAllMovies(){
         return movieRepository.findAllMovies();
    }
}
