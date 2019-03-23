package com.example.cinema.bl;

import com.example.cinema.data.MovieLikeMapper;
import com.example.cinema.data.MovieMapper;

import com.example.cinema.po.DateLikeForm;
import com.example.cinema.po.MovieForm;
import com.example.cinema.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fjj
 * @date 2019/3/12 6:43 PM
 */
@Service
public class MovieServiceImpl implements MovieService {

    private static final String ALREADY_LIKE_ERROR_MESSAGE = "用户已标记该电影为想看";
    private static final String UNLIKE_ERROR_MESSAGE = "用户未标记该电影为想看";
    private static final String USER_NOT_EXIST_ERROR_MESSAGE = "用户不存在";
    private static final String MOVIE_NOT_EXIST_ERROR_MESSAGE = "电影不存在";

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieLikeMapper movieLikeMapper;

    @Override
    public ResponseVO addMovie(MovieForm addMovieForm) {
        try {
            movieMapper.insertOneMovie(addMovieForm);
            return ResponseVO.buildSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO searchOneMovieByIdAndUserId(int id, int userId) {
        try {
            return ResponseVO.buildSuccess(movieMapper.selectMovieByIdAndUserId(id, userId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }

    }

    @Override
    public ResponseVO searchAllMovie() {
        try {
            return ResponseVO.buildSuccess(movieMapper.selectAllMovie());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO likeMovie(int userId, int movieId) {
        //todo: user 判空
        if (userLikeTheMovie(userId, movieId)) {
            return ResponseVO.buildFailure(ALREADY_LIKE_ERROR_MESSAGE);
        } else if (movieMapper.selectMovieById(movieId) == null) {
            return ResponseVO.buildFailure(MOVIE_NOT_EXIST_ERROR_MESSAGE);
        }
        try {
            return ResponseVO.buildSuccess(movieLikeMapper.insertOneLike(movieId, userId));
        } catch (Exception e) {
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO unLikeMovie(int userId, int movieId) {
        if (!userLikeTheMovie(userId, movieId)) {
            return ResponseVO.buildFailure(UNLIKE_ERROR_MESSAGE);
        } else if (movieMapper.selectMovieById(movieId) == null) {
            return ResponseVO.buildFailure(MOVIE_NOT_EXIST_ERROR_MESSAGE);
        }
        try {
            movieLikeMapper.deleteOneLike(movieId, userId);
            return ResponseVO.buildSuccess(movieLikeMapper.deleteOneLike(userId, movieId));
        } catch (Exception e) {
            return ResponseVO.buildFailure("失败");
        }

    }

    @Override
    public ResponseVO getCountOfLikes(int movieId) {
        try {
            return ResponseVO.buildSuccess(movieLikeMapper.selectLikeNums(movieId));
        } catch (Exception e) {
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO getMovieByKeyword(String keyword) {
        if (keyword==null||keyword.equals(""))
            return ResponseVO.buildSuccess(movieMapper.selectAllMovie());
        return ResponseVO.buildSuccess(movieMapper.selectMovieByKeyword(keyword));
    }

    @Override
    public ResponseVO getLikeNumsGroupByDate(int movieId) {
        try {
            return ResponseVO.buildSuccess(movieLikeMapper.getDateLikeNum(movieId));
        } catch (Exception e) {
            return ResponseVO.buildFailure("失败");
        }
    }

    private boolean userLikeTheMovie(int userId, int movieId) {
        return movieLikeMapper.selectLikeMovie(movieId, userId) == 0 ? false : true;
    }


}
