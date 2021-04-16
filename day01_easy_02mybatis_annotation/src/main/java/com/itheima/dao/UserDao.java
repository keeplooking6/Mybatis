package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author keep-looking
 * @date 2021/3/19 - 21:38
 */
public interface UserDao {

    @Select("select * from user")
    List<User> findAll();
}
