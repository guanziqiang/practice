package com.gzq.practice.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/itc")
public class InjectionTestController {
    
    @Value(value="属性注入")
    private String name;
    private long id;

    @Autowired
    public InjectionTestController(@Value(value="12") long id) {
        this.id = id;
    }
    
    @RequestMapping(value="/t1")
    public Object test1() {
        System.out.println(name + " " + id);
        return "success";
    }
}
