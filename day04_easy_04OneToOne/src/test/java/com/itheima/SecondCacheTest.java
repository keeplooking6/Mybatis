package com.itheima;

import com.itheima.dao.AccountDao;
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
 * @Date: 2021/05/15 - 18:12
 */
public class SecondCacheTest {
    private InputStream in;
    private AccountDao accountDao;
    private UserDao userDao;
    SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
    }

    @After
    public void closeResource() throws IOException {
        //      事务提交
//        sqlSession.commit();
        in.close();
    }

    @Test
    public void testCase(){
        SqlSession sqlSession1 = factory.openSession(true);
        userDao = sqlSession1.getMapper(UserDao.class);
        User user1 = userDao.findById(2);
        System.out.println(user1);
        sqlSession1.close();

        SqlSession sqlSession2 = factory.openSession(true);
        userDao = sqlSession2.getMapper(UserDao.class);
        User user2 = userDao.findById(2);
        System.out.println(user2);
        sqlSession2.close();
    }
}
