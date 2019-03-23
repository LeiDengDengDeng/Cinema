package com.example.cinema.bl;

import com.example.cinema.vo.ResponseVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by liying on 2019/3/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class MovieServiceImplTest {
    @Autowired
    MovieService movieService;

    @Test
    public void getLikeNumsGroupByDate() throws Exception {
        ResponseVO res=movieService.getLikeNumsGroupByDate(11);
        res.getContent();
    }

    @Test
    public void likeMovie() throws Exception {
        ResponseVO res=movieService.likeMovie(0,10);
        res.getMessage();
    }

    @Test
    public void unLikeMovie() throws Exception {
        ResponseVO res=movieService.unLikeMovie(0,10);
        res.getMessage();
    }

    @Test
    public void getCountOfLikes() throws Exception {
        ResponseVO res=movieService.getCountOfLikes(10);
        res.getContent();
    }

    @Test
    public void getMovieByKeyword(){
        ResponseVO res = movieService.getMovieByKeyword("惊奇队长");
        System.out.println(res.getContent());
    }
}