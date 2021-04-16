package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * @author keep-looking
 * @date 2021/3/28 - 19:00
 *
 * 持久化层
 */
public interface UserDao {
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(Integer id);
    User findById(Integer id);
    List<User> findByName(String name);
    int findTotal();
}
