package com.example.cinema.service.impl;
import com.example.cinema.dao.MovieMapper;
import com.example.cinema.service.MovieService;

import com.example.cinema.form.MovieForm;
import com.example.cinema.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fjj
 * @date 2019/3/12 6:43 PM
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieMapper movieMapper;
    @Override
    public ResponseVO addMovie(MovieForm addMovieForm) {
        try {
            movieMapper.insertOneMovie(addMovieForm);
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO searchOneMovieById(int id) {
        try {
            return ResponseVO.buildSuccess(movieMapper.selectMovieById(id));
        }catch (Exception e){
            return ResponseVO.buildFailure("失败");
        }

    }

    @Override
    public ResponseVO searchAllMovie() {
        try {
            return ResponseVO.buildSuccess(movieMapper.selectAllMovie());
        }catch (Exception e){
            return ResponseVO.buildFailure("失败");
        }
    }
}
