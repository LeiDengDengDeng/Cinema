package com.example.cinema.bl;

import com.example.cinema.data.MovieMapper;
import com.example.cinema.po.MovieForm;
import com.example.cinema.vo.MovieVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * created by csy on 2019/3/23
 **/

@RunWith(SpringRunner.class)
@SpringBootTest

public class MovieDaoTest {

    @Autowired
    MovieMapper movieMapper;

    @Test
    public void testSearchByKeyword(){
        List<MovieVO> list = movieMapper.selectMovieByKeyword("");
        System.out.println(list.size());
        System.out.println(list.get(0).getName());
    }
}
