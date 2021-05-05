package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @Author: keeplooking
 * @Date: 2021/05/04 - 16:42
 */
public interface AccountDao {
    /**
     * 查询每个账号所属的用户的信息
     * @return
     */
    List<Account> findAll();

    Account findById(Integer id);
    List<Account> findAll2();

}
