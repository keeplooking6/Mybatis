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
    /**
     * 查询每个用户所拥有的全部角色信息
     */
    List<User> findAll();
    User findById(Integer id);


}
