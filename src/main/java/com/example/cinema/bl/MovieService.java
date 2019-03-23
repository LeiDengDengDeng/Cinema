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
     * @param userId
     * @return
     */
    ResponseVO searchOneMovieByIdAndUserId(int id, int userId);

    /**
     * 搜索全部电影
     * @return
     */
    ResponseVO searchAllMovie();

    /**
     * 想看电影
     * @param userId
     * @param movieId
     * @return
     */
    ResponseVO likeMovie(int userId,int movieId);

    /**
     * 取消想看电影
     * @param userId
     * @param movieId
     * @return
     */
    ResponseVO unLikeMovie(int userId,int movieId);

    /**
     * 统计想看电影的人数
     * @param movieId
     * @return
     */
    ResponseVO getCountOfLikes(int movieId);


    /**
     * 根据关键字搜索电影
     * @param keyword
     * @return
     */
    ResponseVO getMovieByKeyword(String keyword);

    /**
     * 获得电影每日的想看人数
     * @param movieId
     * @return
     */
    ResponseVO getLikeNumsGroupByDate(int movieId);

}
