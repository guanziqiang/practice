package com.gzq.practice.spring.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blt")
public class BeanLifeTestController implements InitializingBean{
    
    public BeanLifeTestController() {
        System.out.println("bean生命周期 1，调用构造器");
    }
    
    @RequestMapping("/t1")
    public Object test1() {
        return "success";
    }
    
    public void init() {
        
    }

    @Override
    public void afterPropertiesSet() throws Exception {
       System.out.println("通过实现接口的形式实现bean的初始化方法");
    }

}
