package edu.zc.dao;

import edu.zc.domain.User2;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: keeplooking
 * @Date: 2021/05/15 - 15:47
 */
public interface User2Dao {

    @Select("select * from user")
    @Results(id="userMap",value={
        @Result(id=true,column="id",property="userId"),
            @Result(column="username",property="userName"),
            @Result(column="password",property="pw")
    })
    List<User2> findAll();


    @Select("select * from user where id=#{id}")
//    @ResultMap("userMap")
    @ResultMap(value={"userMap"})
    User2 findOne(Integer id);

//    @ResultMap(value={"userMap"})
    @Insert("insert into user(username,password,phone) values(#{userName},#{pw},#{phone}) ")
    void insertOne(User2 user);
}
