package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author keep-looking
 * @date 2021/3/28 - 19:00
 *
 * 持久化层
 */

@CacheNamespace(blocking = true)
public interface UserDao {
    /**
     * 查询每个用户所拥有的全部账号信息
     * @return
     */
    @Select("select * from user")
    @Results(value={
            @Result(id=true,column="id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column="id",property="account",many=@Many(select="com.itheima.dao.AccountDao.findById",fetchType= FetchType.LAZY))
    })
    List<User> findAll();

    @Select("select * from user where id=#{id}")
    User findById(Integer id);

}
