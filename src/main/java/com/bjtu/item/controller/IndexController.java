package com.bjtu.item.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhaojun on 2017/12/27.
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView toIndex(HttpServletRequest request, HttpServletResponse response){
        System.err.println("index");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/static/page/index.html");
        return modelAndView;
    }
}
