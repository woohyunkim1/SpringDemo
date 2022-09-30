package com.example.demo.controller;

import com.example.demo.model.ImageVO;
import com.example.demo.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @ResponseBody
    @GetMapping("selectImageList")
    public ModelAndView selectImageList() throws Exception {
        ModelAndView mv = new ModelAndView("hellow");
        log.debug("controller Start!!");
        List<ImageVO> selectImageList = imageService.selectImageList();
        log.debug("결과값 :: " + selectImageList);
        mv.addObject("imageList", selectImageList);
        return mv;
    }
}
