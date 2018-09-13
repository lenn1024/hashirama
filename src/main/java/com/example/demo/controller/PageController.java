package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/view")
public class PageController {

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        List<User> users = new ArrayList<>();
        users.add(new User("lenn", 12, false));
        users.add(new User("waw", 11, true));

        mv.addObject("users", users);
        mv.setViewName("/index");

        return mv;
    }
}
