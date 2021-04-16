package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * @author keep-looking
 * @date 2021/3/22 - 17:41
 */
public class UserDaoImpl implements UserDao {

    SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }
    
    @Override
    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> user = session.selectList("com.itheima.dao.UserDao.findAll");
        session.close();
        return user;
    }
}
