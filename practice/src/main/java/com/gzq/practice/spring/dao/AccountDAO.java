package com.gzq.practice.spring.dao;

import org.springframework.stereotype.Repository;

import com.gzq.practice.spring.entities.AccountDO;

@Repository
public interface AccountDAO {
    
    public int update(int money);

//    public AccountDO get();

}
