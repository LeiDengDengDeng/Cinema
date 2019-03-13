package com.example.cinema.bl;

import com.example.cinema.po.MovieForm;
import com.example.cinema.vo.ResponseVO;

/**
 * @author fjj
 * @date 2019/3/12 6:24 PM
 */
public interface MovieService {
    /**
     * 上架电影
     * @param addMovieForm
     * @return
     */
    ResponseVO addMovie(MovieForm addMovieForm);

    /**
     * 根据id搜索电影
     * @param id
     * @return
     */
    ResponseVO searchOneMovieById(int id);

    /**
     * 搜索全部电影
     * @return
     */
    ResponseVO searchAllMovie();
}
