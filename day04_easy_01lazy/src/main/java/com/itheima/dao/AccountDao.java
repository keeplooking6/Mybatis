package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.User;

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
    /**
     * 根据用户id去查询账户
     * @param id
     * @return
     */
    Account findById(Integer id);

}
