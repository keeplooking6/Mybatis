package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: keeplooking
 * @Date: 2021/05/11 - 17:21
 */
public class UserTest2 {
    private InputStream in;
    private SqlSessionFactory factory;

    @Before
    public void before() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
    }

    @After
    public void after() throws IOException {
        in.close();
    }

    /**
     * 测试二级缓存
     */
    @Test
    public void selectCacheLevel2(){
        SqlSession sqlsession1 = factory.openSession();
        UserDao userDao = sqlsession1.getMapper(UserDao.class);
        User user1 = userDao.findById(2);
        System.out.println(user1);
        sqlsession1.close();

        SqlSession sqlSession2 = factory.openSession();
        UserDao userDao2 = sqlSession2.getMapper(UserDao.class);
        User user2 = userDao2.findById(2);
        System.out.println(user2);
        sqlSession2.close();

        System.out.println(user1 == user2);
    }
}
