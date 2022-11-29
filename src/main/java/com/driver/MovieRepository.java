package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Repository
@Component
public class MovieRepository {
    Map<Director,Movie> Map=new HashMap<>();
    Map<String,Movie> movieMap=new HashMap<>();
    Map<String,Director> directorMap=new HashMap<>();
    HashMap<String,List<String>> pairMap=new HashMap<>();

    public void addMovie(Movie movie){
        movieMap.put(movie.getName(),movie);
    }
    public void addDirector(Director director){
        directorMap.put(director.getName(),director);
    }
    public void addMovieDirectorPair(String movie, String director){
        List<String> list=new ArrayList<>();
        if(directorMap.containsKey(director) && movieMap.containsKey(movie)){
            list.add(movie);
            pairMap.put(director,list);
        }
    }
    /*public Map<String,String> check(){
        return map;
    }*/
    public Movie getMovieByName(String movie){
        return movieMap.get(movie);
    }
    public Director getDirectorByName(String director){
        return directorMap.get(director);
    }
    public List<String> getMoviesByDirectorName(String director){
        return pairMap.get(director);
    }
    public List<Movie> findAllMovies(){
        List<Movie> movieList=new ArrayList<>();
        for(Movie movie:movieMap.values())
            movieList.add(movie);
        return movieList;
    }

}
