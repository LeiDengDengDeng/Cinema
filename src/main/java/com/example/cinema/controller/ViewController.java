package com.example.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author deng
 * @date 2019/03/11
 */
@Controller
public class ViewController {
    @RequestMapping(value = "/index")
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = "/admin/movieManage")
    public String getAdminMovieManage() {
        return "admin_movieManage";
    }

    @RequestMapping(value = "/user/home")
    public String getUserMovie() {
        return "user_home";
    }
}
