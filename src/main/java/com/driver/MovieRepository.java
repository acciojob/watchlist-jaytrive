package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Repository
@Component
public class MovieRepository {
    //Map<Director,Movie> Map=new HashMap<>();
    Map<String,Movie> movieMap=new HashMap<>();
    Map<String,Director> directorMap=new HashMap<>();
    Map<String,List<String>> pairMap=new HashMap<>();
    List<String> list;

    public void addMovie(Movie movie){
        movieMap.put(movie.getName(),movie);
    }
    public void addDirector(Director director){
        directorMap.put(director.getName(),director);
    }
    public void addMovieDirectorPair(String movie, String director){
        if(directorMap.containsKey(director) && movieMap.containsKey(movie)){
            if(pairMap.containsKey(director))
                list.add(movie);
            else{
                list=new ArrayList<>();
                list.add(movie);
                pairMap.put(director,list);
            }
        }
    }
    public Movie getMovieByName(String movie){
        return movieMap.get(movie);
    }
    public Director getDirectorByName(String director){
        return directorMap.get(director);
    }
    public List<String> getMoviesByDirectorName(String director){
        return pairMap.get(director);
    }
    public List<String> findAllMovies(){
        List<String> movieList=new ArrayList<>();
        for(String movie:movieMap.keySet())
            movieList.add(movie);
        return movieList;
    }
    public void deleteDirectorByName(String director){
        if(pairMap.containsKey(director)){
            for(String s:pairMap.get(director)){
                movieMap.remove(s);
            }
            directorMap.remove(director);
            pairMap.remove(director);
        }
    }
    public void deleteAllDirectors(){
        for(String s:pairMap.keySet()){
            deleteDirectorByName(s);
        }
    }
}
