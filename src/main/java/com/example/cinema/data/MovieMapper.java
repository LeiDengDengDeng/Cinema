package com.example.cinema.data;

import com.example.cinema.po.MovieForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author fjj
 * @date 2019/3/12 6:26 PM
 */
@Mapper
public interface MovieMapper {
    /**
     * 插入一条电影信息
     * @param addMovieForm
     * @return
     */
    int insertOneMovie(MovieForm addMovieForm);

    /**
     * 根据id查找电影
     * @param id
     * @return
     */
    MovieForm selectMovieById(int id);

    /**
     * 展示所有电影
     * @return
     */
    List<MovieForm> selectAllMovie();
}
