package com.example.demo.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.demo.model.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.awt.*;
import java.util.*;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/basic")
public class BasicController {

    @GetMapping("text-basic")
    public ModelAndView textBasic() throws Exception {
        ModelAndView mv = new ModelAndView("basic/text-basic");
        mv.addObject("data", "Hello <b>Spring</b>");
        return mv;
    }

    @GetMapping("/variable")
    public ModelAndView variable() throws Exception {
        ModelAndView mv = new ModelAndView("basic/variable");
        UserVO userA = new UserVO("userA", 10);
        UserVO userB = new UserVO("userB", 20);

        List<UserVO> list = new ArrayList<>(Arrays.asList(userA, userB));

        Map<String, UserVO> map = new HashMap<>();
        map.put("userA", userA);
        map.put("userB", userB);

        mv.addObject("user", userA);
        mv.addObject("users", list);
        mv.addObject("userMap", map);

        return mv;
    }

    @GetMapping("/basic-object")
    public ModelAndView basicObject(HttpSession httpSession){
        ModelAndView mv = new ModelAndView("basic/basic-object");
        httpSession.setAttribute("sessionData", "Hello Session");
        return mv;
    }

    @Component("helloBean")
    static class HelloBean{
        public String  hello(String data) {
            return "Hello " + data;
        }
    }

    @GetMapping("/date")
    public ModelAndView date() throws Exception{
        ModelAndView mv = new ModelAndView("basic/date");

        mv.addObject("standardDate", new Date());
        mv.addObject("localDate", LocalDate.now());
        mv.addObject("localDateTime", LocalDateTime.now());
        mv.addObject("timestamp", Instant.now());

        return mv;
    }

    @GetMapping("/link")
    public ModelAndView link() throws Exception{
        ModelAndView mv = new ModelAndView("basic/link");
        mv.addObject("param1", "text-basic");
        mv.addObject("param2", "data2");
        return mv;
    }

    @GetMapping("/literal")
    public ModelAndView literal() throws Exception{
        ModelAndView mv = new ModelAndView("basic/literal");
        mv.addObject("data", "Spring!&");
        return mv;
    }

    @GetMapping("/operation")
    public ModelAndView operation() throws Exception {
        ModelAndView mv = new ModelAndView("basic/operation");
        mv.addObject("nullData", null);
        mv.addObject("data", "Spring!");

        return mv;
    }

    @GetMapping("/attribute")
    public ModelAndView attribute() throws Exception {
        ModelAndView mv = new ModelAndView("basic/attribute");
        return mv;
    }

    @GetMapping("/each")
    public ModelAndView each() throws  Exception{
        ModelAndView mv = new ModelAndView("basic/each");
        List<UserVO> users = Arrays.asList(
                new UserVO("userA", 10),
                new UserVO("userB", 20),
                new UserVO("userC", 30)
        );

        mv.addObject("users", users);
        return mv;
    }

    private ModelAndView addUsers(ModelAndView mv){
        List<UserVO> users = Arrays.asList(
            new UserVO("userA", 10),
            new UserVO("userB", 20),
            new UserVO("userC", 30)
        );

        log.debug(users.toString());
        mv.addObject("users", users);
        return mv;
    }

    @GetMapping("/condition")
    public ModelAndView condition () throws  Exception{
        ModelAndView mv = new ModelAndView("basic/condition");
        addUsers(mv);
        return mv;
    }

    @GetMapping("/comments")
    public ModelAndView comments() throws  Exception{
        ModelAndView mv = new ModelAndView("basic/comments");
        mv.addObject("data", "Spring!");
        return mv;
    }

    @GetMapping("/block")
    public  ModelAndView block() throws  Exception{
        ModelAndView mv = new ModelAndView("basic/block");
        addUsers(mv);
        return mv;
    }


}
