package com.gzq.practice.spring.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gzq.practice.spring.service.TransactionTestService;

//@Controller
//@RequestMapping("/blt")
public class BeanLifeTestController implements InitializingBean{
    
    private TransactionTestService transactionTestService;
    
    public BeanLifeTestController() {
        System.out.println("bean生命周期 1，调用构造器");
    }

    @Autowired
    public void setTransactionTestService(TransactionTestService transactionTestService) {
        this.transactionTestService = transactionTestService;
        System.out.println("bean生命周期 2：为属性设值值或者引用");
    }

    
    @PostConstruct
    public void init0() {
        System.out.println("bean生命周期 3， @PostConstruct 注释的init");
    }
    
    public void init() {
        System.out.println("bean生命周期 3，xml注释的init-method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
       System.out.println("bean生命周期 3， InitializingBean init方法 ");
    }
    
    @PreDestroy
    public void destroy0() {
        System.out.println("bean生命周期 5 @PreDestroy注解destroy方法");
    }
    
    public void destroy() {
        System.out.println("bean生命周期 5 xml的destroy方法");
    }

}
