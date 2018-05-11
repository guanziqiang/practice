package com.gzq.practice.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if("beanLifeTestController".equals(beanName)) {
            System.out.println("bean生命周期3-1" + bean.getClass().getName() + " " + beanName); 
        }
        return bean;
    }
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if("beanLifeTestController".equals(beanName)) {
            System.out.println("bean生命周期3-2" + bean.getClass().getName() + " " + beanName); 
        }
        return bean;
    }


}
