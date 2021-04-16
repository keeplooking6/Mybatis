package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * @Author: keeplooking
 * @Date: 2021/04/16 - 10:08
 */
public interface UserDao {
    List<User> findAll();
}
