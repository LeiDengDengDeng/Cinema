package com.example.cinema.controller;

import com.example.cinema.po.MovieForm;
import com.example.cinema.bl.MovieService;
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

    @RequestMapping(value = "/movie/{id}/{userId}", method = RequestMethod.GET)
    public ResponseVO searchOneMovieByIdAndUserId(@PathVariable int id, @PathVariable int userId){
        return movieService.searchOneMovieByIdAndUserId(id, userId);
    }

    @RequestMapping(value = "/movie/all", method = RequestMethod.GET)
    public ResponseVO searchAllMovie(){
        return movieService.searchAllMovie();
    }

    @RequestMapping(value = "/movie/{id}/like", method = RequestMethod.POST)
    public ResponseVO likeMovie(@PathVariable int movieId,@RequestParam int userId){
        return movieService.likeMovie(userId,movieId);
    }
    @RequestMapping(value = "/movie/{id}/unlike", method = RequestMethod.POST)
    public ResponseVO unlikeMovie(@PathVariable int movieId,@RequestParam int userId){
        return movieService.unLikeMovie(userId,movieId);
    }
    @RequestMapping(value = "/movie/{id}/like/count", method = RequestMethod.GET)
    public ResponseVO getMovieLikeCounts(@PathVariable int movieId){
        return movieService.getCountOfLikes(movieId);
    }

}
