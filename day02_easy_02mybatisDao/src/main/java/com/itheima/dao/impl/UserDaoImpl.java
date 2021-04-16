package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

/**
 * @author keep-looking
 * @date 2021/4/1 - 17:25
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }
    @Override
    public List<User> findAll() {
        SqlSession sqlSession = factory.openSession();
        List<User> user = sqlSession.selectList("com.itheima.dao.UserDao.findAll");
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    @Override
    public void save(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("com.itheima.dao.UserDao.save",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.update("com.itheima.dao.UserDao.update",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delete(Integer id) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.delete("com.itheima.dao.UserDao.delete",id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User findById(Integer id) {
        SqlSession sqlSession = factory.openSession();
        User user = sqlSession.selectOne("com.itheima.dao.UserDao.findById", id);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }
    @Override
    public List<User> findByName(String name) {
        SqlSession sqlSession = factory.openSession();
        List<User> user = sqlSession.selectList("com.itheima.dao.UserDao.findByName", name);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    @Override
    public int findTotal() {
        SqlSession sqlSession = factory.openSession();
        Integer count = sqlSession.selectOne("com.itheima.dao.UserDao.findTotal");
        sqlSession.commit();
        sqlSession.close();
        return count;
    }
}
