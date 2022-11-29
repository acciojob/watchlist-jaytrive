package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Component
public class MovieRepository {
    Map<Director,Movie> movieMap=new HashMap<>();
    Set<Movie> movieSet=new HashSet<>();

    public void addMovie(Movie movie){
        movieSet.add(movie);
    }

    public List<Movie> findAllMovies(){
        List<Movie> movieList=new ArrayList<>();
        for(Movie movie:movieSet)
            movieList.add(movie);
        return movieList;
    }
}
