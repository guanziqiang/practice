package com.gzq.practice.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gzq.practice.spring.service.TransactionTestService;

/**
 * 测试spring的事务，关联类{@code com.gzq.practice.spring.service.TransactionTestService} {@code com.gzq.practice.spring.service.impl.TransactionTestServiceImpl}
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/ttc")
public class TransactionTestController {
    
    @Autowired
    private TransactionTestService transactionTestService;
    
    
    @RequestMapping(value="/test1",method=RequestMethod.GET)
    public Object test1() throws Exception {
        transactionTestService.test1();
//        transactionTestService.test2();
        return "success";
    }
    
}
