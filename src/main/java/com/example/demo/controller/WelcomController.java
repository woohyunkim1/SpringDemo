package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.List;

@Slf4j
@RestController
public class WelcomController {
    @ResponseBody
    @GetMapping("/welcom")
    public ModelAndView welcome() throws Exception {
        ModelAndView mv = new ModelAndView("welcome");
        mv.addObject("greeting", "Hello Thymeleaf!");
        log.debug("controller Start!!");
        return mv;
    }
}
