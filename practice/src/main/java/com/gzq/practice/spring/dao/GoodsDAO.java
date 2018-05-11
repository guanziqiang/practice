package com.gzq.practice.spring.dao;

import org.springframework.stereotype.Repository;

import com.gzq.practice.spring.entities.GoodsDO;

@Repository
public interface GoodsDAO {

    //public GoodsDO getByName(String string);

    public void update(int i);

}
