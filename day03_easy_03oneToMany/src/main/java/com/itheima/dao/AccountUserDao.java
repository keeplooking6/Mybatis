package com.itheima.dao;

import com.itheima.domain.AccountUser;

import java.util.List;

/**
 * @Author: keeplooking
 * @Date: 2021/05/04 - 17:45
 */
public interface AccountUserDao {
    List<AccountUser> findAllAccountUser();
}
