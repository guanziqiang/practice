package com.gzq.practice.spring.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gzq.practice.spring.service.TransactionTestService;

/**
 * 测试bean的生命周期，相关类{@code com.gzq.practice.spring.MyBeanPostProcessor}
 * @author Administrator
 *
 */
public class BeanLifeTestController implements InitializingBean, DisposableBean
,BeanNameAware, BeanFactoryAware, ApplicationContextAware{
    
    private TransactionTestService transactionTestService;
    
    public BeanLifeTestController() {
        System.out.println("bean生命周期 1，调用构造器");
    }

    @Autowired
    public void setTransactionTestService(TransactionTestService transactionTestService) {
        this.transactionTestService = transactionTestService;
        System.out.println("bean生命周期 2：为属性设值值或者引用");
    }
    
    
    @Override
    public void setBeanName(String name) {
        System.out.println("bean生命周期 2-1: BeanNameAware 传递过来bean的id" + name);
    }
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("bean生命周期2-2: beanFactory 可以获取到其它的bean");
    }
    

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        System.out.println("bean生命周期2-3: applicationContext 相比BeanFactory更加先进，且无延时加载");
    }


    
    @PostConstruct
    public void init0() {
        System.out.println("bean生命周期 3， @PostConstruct 注释的init");
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("bean生命周期 3， InitializingBean init方法 ");
    }
    
    public void init2() {
        System.out.println("bean生命周期 3，xml注释的init-method");
    }

    
    @PreDestroy
    public void destroy0() {
        System.out.println("bean生命周期 5 @PreDestroy注解destroy方法");
    }
    
    @Override
    public void destroy() throws Exception {
        System.out.println("bean生命周期 5 DisposableBean 销毁方法");
    }
    
    public void destroy2() {
        System.out.println("bean生命周期 5 xml的destroy方法");
    }




}
