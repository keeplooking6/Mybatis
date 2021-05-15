package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Author: keeplooking
 * @Date: 2021/05/04 - 16:42
 */
public interface AccountDao {
    /**
     * 查询每个账号的信息和所属的用户的信息
     * @return
     */
    @Select("select * from account")
    @Results(value={
            @Result(id=true,column="id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(column="uid",property="user",one = @One(select="com.itheima.dao.UserDao.findById",fetchType= FetchType.EAGER))
    })
    List<Account> findAll();

    @Select("select * from account where uid = #{id}")
    Account findById(Integer id);

}
