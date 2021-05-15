package edu.zc.dao;

import edu.zc.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author: keeplooking
 * @Date: 2021/05/15 - 15:04
 */

public interface UserDao {

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id = #{id}")
    User findOne(Integer id);

    @Insert("insert into user(username,password,phone) values(#{username},#{password},#{phone}) ")
    void insertOne(User user);

    @Update("update user set username=#{username},phone=#{phone} where id =#{id}")
    void updateOne(User user);

    @Delete("delete from user where id=#{id}")
    void deleteOne(Integer id);
}
