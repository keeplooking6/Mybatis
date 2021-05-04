package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.domain.Vo.QueryVo;

import java.util.List;

/**
 * @author keep-looking
 * @date 2021/3/28 - 19:00
 *
 * 持久化层
 */
public interface UserDao {
    List<User> findAll();
    User findById(Integer id);
    List<User> findByName(String name);
    List<User> queryVo(QueryVo vo);
    List<User> findByCondition(User user);
    /*
        根据queryvo中提供的用户id来查询用户信息
     */

    List<User> findByIds(QueryVo vo);
}
