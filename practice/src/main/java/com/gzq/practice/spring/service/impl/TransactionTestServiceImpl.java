package com.gzq.practice.spring.service.impl;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gzq.practice.spring.dao.AccountDAO;
import com.gzq.practice.spring.dao.GoodsDAO;
import com.gzq.practice.spring.entities.AccountDO;
import com.gzq.practice.spring.entities.GoodsDO;
import com.gzq.practice.spring.service.TransactionTestService;

@Service
public class TransactionTestServiceImpl implements TransactionTestService{
    
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private GoodsDAO goodsDAO;

    @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    public void test1() throws Exception {
        //AccountDO accountDO = accountDAO.get();
        
        //GoodsDO goods = goodsDAO.getByName("多线程编程");
        
        goodsDAO.update(0);
//        try {
//            ((TransactionTestService)(AopContext.currentProxy())).test2();
//        } catch (Exception e) {
//            System.out.println("test1 中捕获 test2的异常");
//            e.printStackTrace();
//        }
        if(1 == 1) {
//            try {
//                throw new RuntimeException("test1抛出RuntimeException");//默认情况下RuntimeException 自动回滚
//            } catch (Exception e) {
//                System.out.println("test1 捕获自己的异常");
//                e.printStackTrace();
//            }
            throw new Exception("test1抛出可检查性异常"); // 默认情况下 可检查的Exception 不自动回滚
        }
        
    }
    
    @Transactional(propagation = Propagation.MANDATORY,isolation=Isolation.SERIALIZABLE)
    public void test2() {
        System.out.println("test2 方法");
        accountDAO.update(0);
        if(1 == 1) {
//          try {
//            throw new RuntimeException("test2抛出RuntimeException");//默认情况下RuntimeException 自动回滚
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("获取Runtime异常");
//        }
//          throw new Exception("抛出可检查性异常"); // 默认情况下 可检查的Exception 不自动回滚
      }
    }
    
    
    

}
