package com.itheima.dao;

import com.itheima.domain.AccountUser;

import java.util.List;

/**
 * @Author: keeplooking
 * @Date: 2021/05/04 - 17:45
 */
public interface AccountUserDao {
    /**
     * 查询每个账号所属的用户的信息
     * @return
     */
    List<AccountUser> findAllAccountUser();
}
