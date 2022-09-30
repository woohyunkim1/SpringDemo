package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
public class MainController {

    @GetMapping("/")
    public ModelAndView selectImageList() throws Exception {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
