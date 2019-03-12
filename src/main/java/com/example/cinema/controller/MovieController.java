package com.example.cinema.controller;

import com.example.cinema.form.MovieForm;
import com.example.cinema.service.MovieService;
import com.example.cinema.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author fjj
 * @date 2019/3/12 6:17 PM
 */
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/movie/add", method = RequestMethod.POST)
    public ResponseVO addMovie(@RequestBody MovieForm addMovieForm){
        return movieService.addMovie(addMovieForm);
    }

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
    public ResponseVO searchOneMovieById(@PathVariable int id){
        return movieService.searchOneMovieById(id);
    }

    @RequestMapping(value = "/movie/all", method = RequestMethod.GET)
    public ResponseVO searchAllMovie(){
        return movieService.searchAllMovie();
    }
}
